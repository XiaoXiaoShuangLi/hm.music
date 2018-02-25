package com.xxscloud.core.data;

/**
 * @author 李小双 2018.1.1
 */
public enum HandleResultEnum {
    /**
     * 成功.
     */
    SUCCEED,

    /**
     * 错误服务器业务处理错误.
     */
    ERROR,

    /**
     * 参数错误.
     */
    PARAM_ERROR,

    /**
     * 身份验证失败.
     */
    ID_ERROR,


    /**
     * 关闭的请求.
     */
    CLOSE,


    /**
     * 权限不足.
     */
    INSUFFICIENT_PERMISSIONS,


    /**
     * 余额不足.
     */
    INSUFFICIENT_BLANCE,


    /**
     * 会话已关闭.
     */
    SESSION_CLOSE,


    /**
     * 签名错误.
     */
    SIGNATURE_ERROR;
}
