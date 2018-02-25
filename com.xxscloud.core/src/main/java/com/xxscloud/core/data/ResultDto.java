package com.xxscloud.core.data;

/**
 * 创建人: 李小双.
 * 创建时间:  2017/8/16.
 * 描述:
 */
public class ResultDto {

    /**
     * 初始化.
     *
     * @param stateValue 状态
     */
    public ResultDto(final boolean stateValue) {
        state = stateValue;
    }


    /**
     * 初始化 .
     *
     * @param stateValue   状态
     * @param messageValue 消息
     * @param dataValue    结果
     */
    public ResultDto(final boolean stateValue, final String messageValue, final Object dataValue) {
        state = stateValue;
        message = messageValue;
        data = dataValue;
    }

    /**
     * 状态.
     */
    private boolean state;

    /**
     * 消息 .
     */
    private String message;


    /**
     * Object 数据.
     */
    private Object data;

    /**
     * 获取 state .
     *
     * @return state 数据
     */
    public boolean getState() {
        return state;
    }

    /**
     * 设置 state .
     *
     * @param stateValue 设置 state .
     */
    public void setState(final boolean stateValue) {
        state = stateValue;
    }

    /**
     * 获取 message .
     *
     * @return message 数据
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置 message .
     *
     * @param messageValue 设置 message .
     */
    public void setMessage(final String messageValue) {
        message = messageValue;
    }

    /**
     * 获取 data .
     *
     * @return data 数据
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置 data .
     *
     * @param dataValue 设置 data .
     */
    public void setData(final Object dataValue) {
        data = dataValue;
    }
}
