package com.xxscloud.core.data;

import org.apache.http.client.CookieStore;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author 李小双 2018.1.1
 */
public class HttpRequestEntity implements Serializable {

    /**
     * 地址.
     */
    private String url;


    /**
     * 请求头部
     */
    private HashMap<String, String> headers;


    /**
     * 请求正文.
     */
    private byte[] body;

    /**
     * 请求参数.
     */
    private HashMap<String, Object> parameters;

    /**
     * Cookie.
     */
    private CookieStore cookieStore;


    /**
     * 超时时间, 单位毫秒.
     */
    private long time;


    /**
     * 构造器初始化.
     */
    public HttpRequestEntity() {
        //默认3000 毫秒
        this.time = 3000;
    }

    /**
     * 获得url 值.
     *
     * @return url 值
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置新urlValue值.
     *
     * @param urlValue 值
     */
    public void setUrl(String urlValue) {
        url = urlValue;
    }

    /**
     * 获得headers 值.
     *
     * @return headers 值
     */
    public HashMap<String, String> getHeaders() {
        return headers;
    }

    /**
     * 设置新headersValue值.
     *
     * @param headersValue 值
     */
    public void setHeaders(HashMap<String, String> headersValue) {
        headers = headersValue;
    }

    /**
     * 获得body 值.
     *
     * @return body 值
     */
    public byte[] getBody() {
        return body;
    }

    /**
     * 设置新bodyValue值.
     *
     * @param bodyValue 值
     */
    public void setBody(byte[] bodyValue) {
        body = bodyValue;
    }

    /**
     * 获得parameters 值.
     *
     * @return parameters 值
     */
    public HashMap<String, Object> getParameters() {
        return parameters;
    }

    /**
     * 设置新parametersValue值.
     *
     * @param parametersValue 值
     */
    public void setParameters(HashMap<String, Object> parametersValue) {
        parameters = parametersValue;
    }

    /**
     * 获得cookieStore 值.
     *
     * @return cookieStore 值
     */
    public CookieStore getCookieStore() {
        return cookieStore;
    }

    /**
     * 设置新cookieStoreValue值.
     *
     * @param cookieStoreValue 值
     */
    public void setCookieStore(CookieStore cookieStoreValue) {
        cookieStore = cookieStoreValue;
    }

    /**
     * 获得time 值.
     *
     * @return time 值
     */
    public long getTime() {
        return time;
    }

    /**
     * 设置新timeValue值.
     *
     * @param timeValue 值
     */
    public void setTime(long timeValue) {
        time = timeValue;
    }
}
