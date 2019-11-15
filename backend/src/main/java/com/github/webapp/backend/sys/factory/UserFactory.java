package com.github.webapp.backend.sys.factory;

import com.github.webapp.backend.common.auth.context.LoginContextHolder;
import com.github.webapp.backend.common.auth.model.LoginUser;
import com.github.webapp.backend.common.base.consts.ConstantsContext;
import com.github.webapp.backend.common.constant.ManagerStatus;
import com.github.webapp.backend.common.constant.factory.ConstantFactory;
import com.github.webapp.backend.common.util.StringUtil;
import com.github.webapp.backend.sys.entity.SysUser;
import com.github.webapp.backend.sys.entity.dto.SysUserDto;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangweijiang
 * @since 2019-10-31 21:18
 */
public class UserFactory {

    /**
     * 根据请求创建实体
     */
    public static SysUser createUser(SysUserDto userDto, String md5Password, String salt) {
        if (userDto == null) {
            return null;
        } else {
            SysUser user = new SysUser();
            BeanUtils.copyProperties(userDto, user);
            user.setCreateTime(new Date());
            user.setStatus(ManagerStatus.OK.getCode());
            user.setPassword(md5Password);
            user.setSalt(salt);
            return user;
        }
    }

    /**
     * 更新user
     */
    public static SysUser editUser(SysUserDto newUser, SysUser oldUser) {
        if (newUser == null || oldUser == null) {
            return oldUser;
        } else {
            if (StringUtil.isNotEmpty(newUser.getAvatar())) {
                oldUser.setAvatar(newUser.getAvatar());
            }
            if (StringUtil.isNotEmpty(newUser.getName())) {
                oldUser.setName(newUser.getName());
            }
            if (newUser.getBirthday() != null) {
                oldUser.setBirthday(newUser.getBirthday());
            }
            if (newUser.getDeptId() != null) {
                oldUser.setDeptId(newUser.getDeptId());
            }
            if (StringUtil.isNotEmpty(newUser.getSex())) {
                oldUser.setSex(newUser.getSex());
            }
            if (StringUtil.isNotEmpty(newUser.getEmail())) {
                oldUser.setEmail(newUser.getEmail());
            }
            if (StringUtil.isNotEmpty(newUser.getPhone())) {
                oldUser.setPhone(newUser.getPhone());
            }
            return oldUser;
        }
    }

    /**
     * 过滤不安全字段并转化为map
     */
    public static Map<String, Object> removeUnSafeFields(SysUser user) {
        if (user == null) {
            return new HashMap<>();
        } else {
//            Map<String, Object> map = BeanUtil.beanToMap(user);
            Map<String, Object> map = new HashMap<>();
            map.remove("password");
            map.remove("salt");
            map.put("birthday", DateUtil.formatDate(user.getBirthday()));
            return map;
        }
    }

    /**
     * 通过用户表的信息创建一个登录用户
     */
    public static LoginUser createLoginUser(SysUser user) {
        LoginUser loginUser = new LoginUser();

        if (user == null) {
            return loginUser;
        }

        loginUser.setId(user.getId());
        loginUser.setAccount(user.getAccount());
        loginUser.setDeptId(user.getDeptId());
//        loginUser.setDeptName(ConstantFactory.me().getDeptName(user.getDeptId()));
        loginUser.setDeptName("");
        loginUser.setName(user.getName());
        loginUser.setEmail(user.getEmail());

        loginUser.setAvatar("/api/system/preview/" + user.getAvatar());

        return loginUser;
    }

    /**
     * 判断用户是否是从oauth2登录过来的
     */
    public static boolean oauth2Flag() {
        String account = LoginContextHolder.getContext().getUser().getAccount();
        if (account.startsWith(ConstantsContext.getOAuth2UserPrefix())) {
            return true;
        } else {
            return false;
        }
    }
}
