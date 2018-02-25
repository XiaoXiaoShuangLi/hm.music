package com.xxscloud.api.data;

/**
 * @author 李小双 2018.2.22
 */
public class TimeDto {

    /**
     * 毫秒数.
     */
    private Long time;

    public TimeDto() {
    }

    public TimeDto(Long time) {
        this.time = time;
    }

    /**
     * 获得time 值.
     *
     * @return time 值
     */
    public Long getTime() {
        return time;
    }

    /**
     * 设置新timeValue值.
     *
     * @param timeValue 值
     */
    public void setTime(Long timeValue) {
        time = timeValue;
    }
}
