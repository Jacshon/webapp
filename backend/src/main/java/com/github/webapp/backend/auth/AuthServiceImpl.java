package com.github.webapp.backend.auth;

import com.github.webapp.backend.auth.cache.SessionManager;
import com.github.webapp.backend.common.auth.context.LoginContextHolder;
import com.github.webapp.backend.common.auth.jwt.JwtTokenUtil;
import com.github.webapp.backend.common.auth.jwt.payload.JwtPayLoad;
import com.github.webapp.backend.common.auth.model.LoginUser;
import com.github.webapp.backend.common.auth.service.AuthService;
import com.github.webapp.backend.common.auth.util.SpringContextHolder;
import com.github.webapp.backend.common.constant.ManagerStatus;
import com.github.webapp.backend.common.constant.factory.ConstantFactory;
import com.github.webapp.backend.common.exception.PermissionForbiddenException;
import com.github.webapp.backend.common.exception.UserNotLoginException;
import com.github.webapp.backend.common.util.*;
import com.github.webapp.backend.log.LogManager;
import com.github.webapp.backend.log.factory.LogTaskFactory;
import com.github.webapp.backend.sys.entity.SysUser;
import com.github.webapp.backend.sys.factory.UserFactory;
import com.github.webapp.backend.sys.service.SysDictService;
import com.github.webapp.backend.sys.service.SysMenuService;
import com.github.webapp.backend.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.github.webapp.backend.common.base.consts.ConstantsContext.getJwtSecretExpireSec;
import static com.github.webapp.backend.common.base.consts.ConstantsContext.getTokenHeaderName;
import static com.github.webapp.backend.common.enums.ResponseCode.USER_ACCOUNT_FORBIDDEN;
import static com.github.webapp.backend.common.enums.ResponseCode.USER_NOT_EXIST;

/**
 * @author wangweijiang
 * @since 2019-10-29 14:25
 */
@Service
public class AuthServiceImpl  implements AuthService{
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysDictService dictService;

    @Autowired
    private SessionManager sessionManager;

    public static AuthService me() {
        return SpringContextHolder.getBean(AuthService.class);
    }

    @Override
    public String login(String username, String password) {

        SysUser user = sysUserService.getByAccount(username);

        // 账号不存在
        if (null == user) {
            throw new UserNotLoginException();
        }

        //验证账号密码是否正确
        String requestMd5 = SaltUtil.md5Encrypt(password, user.getSalt());
        String dbMd5 = user.getPassword();
        if (dbMd5 == null || !dbMd5.equalsIgnoreCase(requestMd5)) {
            throw new PermissionForbiddenException();
        }

        return login(username);
    }

    @Override
    public String login(String username) {

        SysUser user = sysUserService.getByAccount(username);

        // 账号不存在
        if (null == user) {
            throw new PermissionForbiddenException(USER_NOT_EXIST);
        }

        // 账号被冻结
        if (!user.getStatus().equals(ManagerStatus.OK.getCode())) {
            throw new PermissionForbiddenException(USER_ACCOUNT_FORBIDDEN);
        }

        //记录登录日志
        LogManager.me().executeLog(LogTaskFactory.loginLog(user.getId(), IpUtil.getRealIp(RequestContextUtil.getRequest())));

        //TODO key的作用
        JwtPayLoad payLoad = new JwtPayLoad(user.getId(), user.getAccount(), "xxxx");

        //创建token
        String token = JwtTokenUtil.generateToken(payLoad);

        //创建登录会话
        sessionManager.createSession(token, user(username));

        //创建cookie
        addLoginCookie(token);

        return token;
    }

    @Override
    public void addLoginCookie(String token) {
        //创建cookie
        Cookie authorization = new Cookie(getTokenHeaderName(), token);
        authorization.setMaxAge(getJwtSecretExpireSec().intValue());
        authorization.setHttpOnly(true);
        authorization.setPath("/");
        HttpServletResponse response = RequestContextUtil.getResponse();
        response.addCookie(authorization);
    }

    @Override
    public void logout() {
        String token = LoginContextHolder.getContext().getToken();
        logout(token);
    }

    @Override
    public void logout(String token) {

        //记录退出日志
        LogManager.me().executeLog(LogTaskFactory.exitLog(LoginContextHolder.getContext().getUser().getId(), IpUtil.getRealIp(RequestContextUtil.getRequest())));

        //删除Auth相关cookies
        Cookie[] cookies = RequestContextUtil.getRequest().getCookies();
        for (Cookie cookie : cookies) {
            String tokenHeader = getTokenHeaderName();
            if (tokenHeader.equalsIgnoreCase(cookie.getName())) {
                Cookie temp = new Cookie(cookie.getName(), "");
                temp.setMaxAge(0);
                RequestContextUtil.getResponse().addCookie(temp);
            }
        }

        //删除会话
        sessionManager.removeSession(token);
    }

    @Override
    public LoginUser user(String account) {

        SysUser user = sysUserService.getByAccount(account);

        LoginUser loginUser = UserFactory.createLoginUser(user);

        //用户角色数组
        String[] roleArray = user.getRoleId().split(",");

        //如果角色是空就直接返回
        if (roleArray.length == 0) {
            return loginUser;
        }

        //获取用户角色列表
        List<Long> roleList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();
        List<String> roleTipList = new ArrayList<>();
        for (String roleId : roleArray) {
            if (StringUtil.isEmpty(roleId)) {
                continue;
            }
            roleList.add(Long.valueOf(roleId));
//            roleNameList.add(ConstantFactory.me().getSingleRoleName(roleId));
//            roleTipList.add(ConstantFactory.me().getSingleRoleTip(roleId));
        }
        loginUser.setRoleList(roleList);
        loginUser.setRoleNames(roleNameList);
        loginUser.setRoleTips(roleTipList);

//        //根据角色获取系统的类型
//        List<String> systemTypes = this.sysMenuService.getMenusTypesByRoleIds(roleList);
//
//        //通过字典编码
//        List<Map<String, Object>> dictsByCodes = dictService.getDictsByCodes(systemTypes);
//        loginUser.setSystemTypes(dictsByCodes);

        //设置权限列表
        Set<String> permissionSet = new HashSet<>();
        for (Long roleId : roleList) {
            List<String> permissions = this.findPermissionsByRoleId(roleId);
            if (permissions != null) {
                for (String permission : permissions) {
                    if (StringUtil.isNotEmpty(permission)) {
                        permissionSet.add(permission);
                    }
                }
            }
        }
        loginUser.setPermissions(permissionSet);

        return loginUser;
    }

    @Override
    public List<String> findPermissionsByRoleId(Long roleId) {
        return null;//sysUserService.getResUrlsByRoleId(roleId);
    }

    @Override
    public boolean check(String[] roleNames) {
        LoginUser user = LoginContextHolder.getContext().getUser();
        if (null == user) {
            return false;
        }
//        ArrayList<String> objects = (ArrayList)Arrays.asList(roleNames);
//        String join = CollectionUtil.join(objects, ",");
//        if (LoginContextHolder.getContext().hasAnyRoles(join)) {
//            return true;
//        }
        return false;
    }

    @Override
    public boolean checkAll() {
        HttpServletRequest request = RequestContextHolderUtil.getRequest();
        LoginUser user = LoginContextHolder.getContext().getUser();
        if (null == user) {
            return false;
        }
//        String requestURI = request.getRequestURI().replaceFirst(ConfigListener.getConf().get("contextPath"), "");
        String requestURI = request.getRequestURI();
        String[] str = requestURI.split("/");
        if (str.length > 3) {
            requestURI = "/" + str[1] + "/" + str[2];
        }
        if (LoginContextHolder.getContext().hasPermission(requestURI)) {
            return true;
        }
        return false;
    }
}
