package com.xxscloud.core;

/**
 * @author 李小双 2018.1.1
 * 参数异常
 */
public class ParameterException extends RuntimeException {

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(Throwable e) {
        super(e);
    }

    public ParameterException(String message, Throwable e) {
        super(message, e);
    }
}
