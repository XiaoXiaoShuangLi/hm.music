package com.xxscloud.core;

import com.xxscloud.core.data.HttpMethodEnum;
import com.xxscloud.core.data.HttpRequestEntity;
import com.xxscloud.core.data.HttpResponseEntity;
import com.xxscloud.core.http.BaseHttpUtils;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;

import java.util.*;

/**
 * @author : 李小双 2018.1.1
 * 描述: HTTP 浏览器的工具类库
 */
public class HttpUtils extends BaseHttpUtils {


    /**
     * 客户端请求上下文.
     */
    private HttpClientContext httpClientContext;

    /**
     * 初始化.
     */
    public HttpUtils() {
        this(null);
    }

    /**
     * 初始化.
     *
     * @param cookieStore cookie 数据
     */
    public HttpUtils(CookieStore cookieStore) {
        httpClientContext = HttpClientContext.create();
        if (Objects.isNull(cookieStore)) {
            httpClientContext.setCookieStore(cookieStore);
        }
    }


    /**
     * 发送一个Get 请求 .
     *
     * @param url Url地址
     * @return 处理结果
     */
    public HttpResponseEntity get(final String url) {
        return get(url, null);
    }

    /**
     * 发送一个Get 请求 .
     *
     * @param url     Url地址
     * @param headers 请求头部
     * @return 处理结果
     */
    public HttpResponseEntity get(final String url, final HashMap<String, String> headers) {
        HttpRequestEntity httpRequestEntity = new HttpRequestEntity();
        httpRequestEntity.setUrl(url);
        httpRequestEntity.setHeaders(headers);
        HttpResponseEntity httpResponseEntity = base(httpRequestEntity, HttpMethodEnum.DELETE, httpClientContext);
        if (httpResponseEntity.isSucceed()) {
            this.httpClientContext = httpResponseEntity.getHttpClientContext();
        }
        return httpResponseEntity;
    }

    /**
     * 发送一个POST 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @return 处理结果
     */
    public HttpResponseEntity post(final String url, final HashMap<String, Object> parameters) {
        return post(url, parameters, new HashMap<>());
    }

    /**
     * 发送一个POST 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @param headers    请求头部
     * @return 处理结果
     */
    public HttpResponseEntity post(final String url, final HashMap<String, Object> parameters, final HashMap<String, String> headers) {
        HttpRequestEntity httpRequestEntity = new HttpRequestEntity();
        httpRequestEntity.setUrl(url);
        httpRequestEntity.setHeaders(headers);
        httpRequestEntity.setParameters(parameters);
        return base(httpRequestEntity, HttpMethodEnum.POST, httpClientContext);
    }

    /**
     * 发送一个POST 请求.
     *
     * @param url     url 地址
     * @param headers 请求头部
     * @param body    请求正文
     * @return 处理结果
     */
    public HttpResponseEntity post(final String url, final HashMap<String, String> headers, final byte[] body) {
        HttpRequestEntity httpRequestEntity = new HttpRequestEntity();
        httpRequestEntity.setUrl(url);
        httpRequestEntity.setHeaders(headers);
        httpRequestEntity.setBody(body);
        HttpResponseEntity httpResponseEntity = base(httpRequestEntity, HttpMethodEnum.DELETE, httpClientContext);
        if (httpResponseEntity.isSucceed()) {
            this.httpClientContext = httpResponseEntity.getHttpClientContext();
        }
        return httpResponseEntity;
    }

    /**
     * 发送一个Put 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @return 处理结果
     */
    public HttpResponseEntity put(final String url, final HashMap<String, Object> parameters) {
        return put(url, parameters, new HashMap<>());
    }

    /**
     * 发送一个Put 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @param headers    请求正文
     * @return 响应实体
     */
    public HttpResponseEntity put(final String url, final HashMap<String, Object> parameters, final HashMap<String, String> headers) {
        HttpRequestEntity httpRequestEntity = new HttpRequestEntity();
        httpRequestEntity.setUrl(url);
        httpRequestEntity.setHeaders(headers);
        httpRequestEntity.setParameters(parameters);
        return base(httpRequestEntity, HttpMethodEnum.PUT, httpClientContext);
    }

    /**
     * 发送一个Put 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @param body       请求body
     * @return 响应实体
     */
    public HttpResponseEntity put(final String url, final HashMap<String, Object> parameters, final byte[] body) {
        HttpRequestEntity httpRequestEntity = new HttpRequestEntity();
        httpRequestEntity.setUrl(url);
        httpRequestEntity.setParameters(parameters);
        httpRequestEntity.setBody(body);
        HttpResponseEntity httpResponseEntity = base(httpRequestEntity, HttpMethodEnum.DELETE, httpClientContext);
        if (httpResponseEntity.isSucceed()) {
            this.httpClientContext = httpResponseEntity.getHttpClientContext();
        }
        return httpResponseEntity;
    }

    /**
     * 发送一个DELETE 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @return 响应实体
     */
    public HttpResponseEntity delete(final String url, final HashMap<String, Object> parameters) {
        return delete(url, parameters, null);
    }

    /**
     * 发送一个DELETE 请求.
     *
     * @param url        请求地址
     * @param parameters 请求参数
     * @param headers    请求头部
     * @return 响应实体
     */
    public HttpResponseEntity delete(final String url, final HashMap<String, Object> parameters, final HashMap<String, String> headers) {
        HttpRequestEntity httpRequestEntity = new HttpRequestEntity();
        httpRequestEntity.setUrl(url);
        httpRequestEntity.setHeaders(headers);
        httpRequestEntity.setParameters(parameters);
        HttpResponseEntity httpResponseEntity = base(httpRequestEntity, HttpMethodEnum.DELETE, httpClientContext);
        if (httpResponseEntity.isSucceed()) {
            this.httpClientContext = httpResponseEntity.getHttpClientContext();
        }
        return httpResponseEntity;
    }

}
