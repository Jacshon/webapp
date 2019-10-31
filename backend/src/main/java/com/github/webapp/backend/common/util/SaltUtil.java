package com.github.webapp.backend.common.util;

/**
 * @author wangweijiang
 * @since 2019-10-31 20:57
 */
public class SaltUtil {
    /**
     * 获取密码盐
     *
     * @author fengshuonan
     * @Date 2019/7/20 17:35
     */
    public static String getRandomSalt() {
        return StringUtil.getRandomString(5);
    }

    /**
     * md5加密，带盐值
     *
     * @author fengshuonan
     * @Date 2019/7/20 17:36
     */
    public static String md5Encrypt(String password, String salt) {
        if (StringUtil.isEmpty(password) || StringUtil.isEmpty(salt)) {
            throw new IllegalArgumentException("密码或盐为空！");
        } else {
            return MD5Util.encrypt(password + salt);
        }
    }
}
