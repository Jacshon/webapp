package com.github.webapp.backend.common.response;

import java.io.Serializable;

/**
 * 返回格式接口，所有实现该接口的类，都可用于结果接收及返回
 *
 * 由于本系统使用基于注解的方式实现返回结果处理，所以，此处需要以提供接口，
 * 如果只是想简单的定义统一的返回结果，完全不需要定义一个接口
 *
 * @author wangweijiang
 * @since 2019-10-08 15:02
 */
public interface Response extends Serializable {
}
