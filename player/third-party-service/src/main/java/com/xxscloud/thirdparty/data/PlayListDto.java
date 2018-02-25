package com.xxscloud.thirdparty.data;

public class PlayListDto {

    /**
     * id 名称.
     */
    private String id;

    /**
     * 名称.
     */
    private String name;

    /**
     * 封面地址.
     */
    private String imageUrl;

    public PlayListDto() {
    }

    public PlayListDto(final String name, final String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

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
     * 获取 imageUrl .
     *
     * @return imageUrl 数据
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置 imageUrl .
     *
     * @param imageUrlValue 设置 imageUrl .
     */
    public void setImageUrl(final String imageUrlValue) {
        imageUrl = imageUrlValue;
    }
}
