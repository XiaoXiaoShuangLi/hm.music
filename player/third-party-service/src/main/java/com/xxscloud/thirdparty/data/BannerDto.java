package com.xxscloud.thirdparty.data;

/**
 * @author 李小双 2018.2.22
 * 头部信息.
 */
public class BannerDto {



    /**
     * 图片地址.
     */
    private String imageUrl;

    /**
     * 跳转参数.
     */
    private String parameters;

    /**
     * 标题.
     */
    private String title;

    /**
     * 正文.
     */
    private String context;

    public BannerDto() {
    }

    public BannerDto(String imageUrl, String parameters) {
        this.imageUrl = imageUrl;
        this.parameters = parameters;
    }

    public BannerDto(String imageUrl, String parameters, String title, String context) {
        this.imageUrl = imageUrl;
        this.parameters = parameters;
        this.title = title;
        this.context = context;
    }

    /**
     * 获得imageUrl 值.
     *
     * @return imageUrl 值
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置新imageUrlValue值.
     *
     * @param imageUrlValue 值
     */
    public void setImageUrl(String imageUrlValue) {
        imageUrl = imageUrlValue;
    }

    /**
     * 获得parameters 值.
     *
     * @return parameters 值
     */
    public String getParameters() {
        return parameters;
    }

    /**
     * 设置新parametersValue值.
     *
     * @param parametersValue 值
     */
    public void setParameters(String parametersValue) {
        parameters = parametersValue;
    }

    /**
     * 获得title 值.
     *
     * @return title 值
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置新titleValue值.
     *
     * @param titleValue 值
     */
    public void setTitle(String titleValue) {
        title = titleValue;
    }

    /**
     * 获得context 值.
     *
     * @return context 值
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置新contextValue值.
     *
     * @param contextValue 值
     */
    public void setContext(String contextValue) {
        context = contextValue;
    }
}
