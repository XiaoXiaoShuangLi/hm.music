package com.xxscloud.thirdparty.data;

public class ArtistsInfoDto extends NetEaseMusicResponseEntity {

    /**
     * id.
     */
    private String id;

    /**
     * 名称.
     */
    private String name;

    /**
     * 头像地址.
     */
    private String picUrl;

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
     * 获取 name .
     *
     * @return name 数据
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name .
     *
     * @param nameValue 设置 name .
     */
    public void setName(final String nameValue) {
        name = nameValue;
    }

    /**
     * 获取 picUrl .
     *
     * @return picUrl 数据
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置 picUrl .
     *
     * @param picUrlValue 设置 picUrl .
     */
    public void setPicUrl(final String picUrlValue) {
        picUrl = picUrlValue;
    }
}
