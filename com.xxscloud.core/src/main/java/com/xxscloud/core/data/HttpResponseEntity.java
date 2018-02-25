package com.xxscloud.core.data;

import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;

import java.beans.Encoder;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author 李小双 2018.1.1
 */
public class HttpResponseEntity {

    /**
     * 是否执行成功.
     */
    private boolean succeed;

    /**
     * 响应代码.
     */
    private ResponseEnum code;

    /**
     * 消息状态.
     */
    private String message;

    /**
     * 响应正文.
     */
    private byte[] body;

    /**
     * 响应头部.
     */
    private HashMap<String, String> headers;

    /**
     * Cookie .
     */
    private CookieStore cookieStore;

    /**
     * 上下文.
     */
    private HttpClientContext httpClientContext;

    public HttpResponseEntity() {
    }

    public HttpResponseEntity(final boolean succeed, final ResponseEnum responseEnum, final String message) {
        this.succeed = succeed;
        this.code = responseEnum;
        this.message = message;
    }

    public HttpResponseEntity(final boolean succeed, final ResponseEnum responseEnum, final byte[] body,
                              final HashMap<String, String> headers, final CookieStore cookieStore,
                              final HttpClientContext httpClientContext) {
        this.succeed = succeed;
        this.code = responseEnum;
        this.body = body;
        this.headers = headers;
        this.cookieStore = cookieStore;
        this.httpClientContext = httpClientContext;
    }


    /**
     * 获得succeed 值.
     *
     * @return succeed 值
     */
    public boolean isSucceed() {
        return succeed;
    }

    /**
     * 设置新succeedValue值.
     *
     * @param succeedValue 值
     */
    public void setSucceed(boolean succeedValue) {
        succeed = succeedValue;
    }

    /**
     * 获得code 值.
     *
     * @return code 值
     */
    public ResponseEnum getCode() {
        return code;
    }

    /**
     * 设置新codeValue值.
     *
     * @param codeValue 值
     */
    public void setCode(ResponseEnum codeValue) {
        code = codeValue;
    }

    /**
     * 获得message 值.
     *
     * @return message 值
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置新messageValue值.
     *
     * @param messageValue 值
     */
    public void setMessage(String messageValue) {
        message = messageValue;
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
     * 获得body 值.
     *
     * @return body 值.
     */
    public String getBodyString() {
        try {
            return getBodyString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获得body 值.
     *
     * @param charsetName 字符串编码.
     * @return body 值.
     * @throws UnsupportedEncodingException 不支持的编码异常.
     */
    public String getBodyString(String charsetName) throws UnsupportedEncodingException {
        if (Objects.isNull(body)) {
            return null;
        }
        return new String(body, charsetName);
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
        this.headers = headersValue;
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
     * 获取 succeed .
     *
     * @return succeed 数据
     */
    public boolean getSucceed() {
        return succeed;
    }

    /**
     * 获取 httpClientContext .
     *
     * @return httpClientContext 数据
     */
    public HttpClientContext getHttpClientContext() {
        return httpClientContext;
    }


}
