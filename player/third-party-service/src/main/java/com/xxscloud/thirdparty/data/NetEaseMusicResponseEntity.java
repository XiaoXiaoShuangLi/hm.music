package com.xxscloud.thirdparty.data;

import java.io.Serializable;

public class NetEaseMusicResponseEntity<T> implements Serializable {
    /**
     * 响应代码.
     */
    private int code;

    /**
     * 响应内容.
     */
    private T data;

    /**
     * 响应内容.
     */
    private T lyricUser;

    /**
     * 响应内容.
     */
    private T result;

    /**
     * 获取 code .
     *
     * @return code 数据
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置 code .
     *
     * @param codeValue 设置 code .
     */
    public void setCode(final int codeValue) {
        code = codeValue;
    }

    /**
     * 获取 data .
     *
     * @return data 数据
     */
    public T getData() {
        return data;
    }

    /**
     * 设置 data .
     *
     * @param dataValue 设置 data .
     */
    public void setData(final T dataValue) {
        data = dataValue;
    }

    /**
     * 获取 lyricUser .
     *
     * @return lyricUser 数据
     */
    public T getLyricUser() {
        return lyricUser;
    }

    /**
     * 设置 lyricUser .
     *
     * @param lyricUserValue 设置 lyricUser .
     */
    public void setLyricUser(final T lyricUserValue) {
        lyricUser = lyricUserValue;
    }

    /**
     * 获取 result .
     *
     * @return result 数据
     */
    public T getResult() {
        return result;
    }

    /**
     * 设置 result .
     *
     * @param resultValue 设置 result .
     */
    public void setResult(final T resultValue) {
        result = resultValue;
    }
}
