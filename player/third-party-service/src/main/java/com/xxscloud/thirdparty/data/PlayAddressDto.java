package com.xxscloud.thirdparty.data;

import java.util.List;

public class PlayAddressDto extends NetEaseMusicResponseEntity<List<PlayAddressDto>> {

    /**
     * id.
     */
    private String id;

    /**
     * url 地址.
     */
    private String url;

    /**
     * 类型.
     */
    private String type;

    /**
     * MD5 校验值.
     */
    private String md5;


    /**
     * 获取 id .
     *
     * @return id 数据
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 id .
     *
     * @param idValue 设置 id .
     */
    public void setId(final String idValue) {
        id = idValue;
    }

    /**
     * 获取 url .
     *
     * @return url 数据
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置 url .
     *
     * @param urlValue 设置 url .
     */
    public void setUrl(final String urlValue) {
        url = urlValue;
    }

    /**
     * 获取 type .
     *
     * @return type 数据
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 type .
     *
     * @param typeValue 设置 type .
     */
    public void setType(final String typeValue) {
        type = typeValue;
    }

    /**
     * 获取 md5 .
     *
     * @return md5 数据
     */
    public String getMd5() {
        return md5;
    }

    /**
     * 设置 md5 .
     *
     * @param md5Value 设置 md5 .
     */
    public void setMd5(final String md5Value) {
        md5 = md5Value;
    }
}
