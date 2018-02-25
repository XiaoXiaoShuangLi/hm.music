package com.xxscloud.core.http;

import com.xxscloud.core.data.HttpMethodEnum;
import com.xxscloud.core.data.HttpRequestEntity;
import com.xxscloud.core.data.HttpResponseEntity;

import java.util.HashMap;

/**
 * HttpUtils 接口
 */
public interface HttpUtils {

    /**
     * 发送一个Get 请求 .
     *
     * @param url Url地址
     * @return 处理结果
     */
    HttpResponseEntity get(final String url);

    /**
     * 发送一个Get 请求 .
     *
     * @param url     Url地址
     * @param headers 请求头部
     * @return 处理结果
     */
    HttpResponseEntity get(final String url, final HashMap<String, String> headers);

    /**
     * 发送一个POST 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @return 处理结果
     */
    HttpResponseEntity post(final String url, final HashMap<String, Object> parameters);

    /**
     * 发送一个POST 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @param headers    请求头部
     * @return 处理结果
     */
    HttpResponseEntity post(final String url, final HashMap<String, Object> parameters, final HashMap<String, String> headers);

    /**
     * 发送一个POST 请求.
     *
     * @param url     url 地址
     * @param headers 请求头部
     * @param body    请求正文
     * @return 处理结果
     */
    HttpResponseEntity post(final String url, final HashMap<String, String> headers, final byte[] body);

    /**
     * 发送一个Put 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @return 处理结果
     */
    HttpResponseEntity put(final String url, final HashMap<String, Object> parameters);

    /**
     * 发送一个Put 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @param headers    请求正文
     * @return 响应实体
     */
    HttpResponseEntity put(final String url, final HashMap<String, Object> parameters, final HashMap<String, String> headers);

    /**
     * 发送一个Put 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @param body       请求body
     * @return 响应实体
     */
    HttpResponseEntity put(final String url, final HashMap<String, Object> parameters, final byte[] body);

    /**
     * 发送一个DELETE 请求.
     *
     * @param url        url 地址
     * @param parameters 请求参数
     * @return 响应实体
     */
    HttpResponseEntity delete(final String url, final HashMap<String, Object> parameters);

    /**
     * 发送一个DELETE 请求.
     *
     * @param url        请求地址
     * @param parameters 请求参数
     * @param headers    请求头部
     * @return 响应实体
     */
    HttpResponseEntity delete(final String url, final HashMap<String, Object> parameters, final HashMap<String, String> headers);
}
