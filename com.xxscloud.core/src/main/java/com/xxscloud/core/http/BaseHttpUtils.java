package com.xxscloud.core.http;

import com.sun.istack.internal.NotNull;
import com.xxscloud.core.Utils;
import com.xxscloud.core.data.HttpMethodEnum;
import com.xxscloud.core.data.HttpRequestEntity;
import com.xxscloud.core.data.HttpResponseEntity;
import com.xxscloud.core.data.ResponseEnum;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public abstract class BaseHttpUtils implements HttpUtils {

    /**
     * HttpClick 对象.
     */
    private static final HttpClient HTTPCLIENT;

    static {
        HTTPCLIENT = HttpClients.createDefault();
    }

    /**
     * 发送请求底层 .
     *
     * @param httpRequestEntity 请求实体数据
     * @param httpMethodEnum    请求方式
     * @param httpClientContext 请求上下文
     * @return 响应实体
     */
    @NotNull
    protected HttpResponseEntity base(final HttpRequestEntity httpRequestEntity, final HttpMethodEnum httpMethodEnum, HttpClientContext httpClientContext) {
        //校验参数
        if (Utils.isNullOrEmpty(httpRequestEntity.getUrl())) {
            return new HttpResponseEntity(false, ResponseEnum.ERROR, "url is empty");
        }

        try {
            final HttpRequestBase httpRequestBase;
            switch (httpMethodEnum) {
                case GET:
                    httpRequestBase = new HttpGet(httpRequestEntity.getUrl());
                    break;
                case POST:
                    HttpPost httpPost = new HttpPost(httpRequestEntity.getUrl());
                    httpPost.setEntity(getBody(httpRequestEntity));
                    httpRequestBase = httpPost;
                    break;
                case PUT:
                    HttpPut httpPut = new HttpPut(httpRequestEntity.getUrl());
                    httpPut.setEntity(getBody(httpRequestEntity));
                    httpRequestBase = httpPut;
                    break;
                case DELETE:
                    httpRequestBase = new HttpDelete(httpRequestEntity.getUrl());
                    break;
                default:
                    httpRequestBase = new HttpGet(httpRequestEntity.getUrl());
                    break;
            }

            //添加标头
            if (!Objects.isNull(httpRequestEntity.getHeaders())) {
                for (Map.Entry<String, String> header : httpRequestEntity.getHeaders().entrySet()) {
                    if (Utils.isNullOrEmpty(header.getKey()) || Utils.isNullOrEmpty(header.getValue())) {
                        return new HttpResponseEntity(false, ResponseEnum.ERROR, "header parameter is empty");
                    }
                    httpRequestBase.addHeader(header.getKey(), header.getValue());
                }
            }
            httpRequestBase.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36");

//            httpRequestBase.addHeader("Content-Type","application/x-www-form-urlencoded");
//            httpRequestBase.addHeader("Origin","https://music.163.com");


            httpClientContext = Objects.isNull(httpClientContext) ? HttpClientContext.create() : httpClientContext;
            final HttpResponse response = HTTPCLIENT.execute(httpRequestBase, httpClientContext);

            //响应正文
            byte[] result = EntityUtils.toByteArray(response.getEntity());
            //HashMap 的初始大小
            final int headSize = response.getAllHeaders().length;
            HashMap<String, String> headers = new HashMap<>(headSize);
            for (final Header header : response.getAllHeaders()) {
                headers.put(header.getName(), header.getValue());
            }
            ResponseEnum responseEnum = ResponseEnum.SUCCEED.setState(response.getStatusLine().getStatusCode());
            if (Objects.equals(responseEnum, ResponseEnum.SUCCEED)) {
                return new HttpResponseEntity(true, responseEnum, result, headers, httpClientContext.getCookieStore(), httpClientContext);
            }
            return new HttpResponseEntity(false, responseEnum, result, headers, httpClientContext.getCookieStore(), httpClientContext);
        } catch (IOException ex) {
            ex.printStackTrace();
            return new HttpResponseEntity(false, ResponseEnum.ERROR, ex.getMessage());
        }
    }

    /**
     * 获得一个body 的实体.
     *
     * @param httpRequestEntity 请求实体
     * @return 包含body 数据的请求实体.
     * @throws UnsupportedEncodingException 编码异常
     */
    private HttpEntity getBody(final HttpRequestEntity httpRequestEntity) throws UnsupportedEncodingException {
        List<BasicNameValuePair> basicNameValuePairList = new ArrayList<>();
        if (!Objects.isNull(httpRequestEntity.getParameters())) {
            for (Map.Entry<String, Object> parameter : httpRequestEntity.getParameters().entrySet()) {
                if (!Utils.isNullOrEmpty(parameter.getKey()) && !Objects.isNull(parameter.getValue())) {
                    basicNameValuePairList.add(new BasicNameValuePair(parameter.getKey(), String.valueOf(parameter.getValue())));
                }
            }
        }

        //有参数传递参数
        if (basicNameValuePairList.size() > 0) {
            return new UrlEncodedFormEntity(basicNameValuePairList);
        }
        //没有参数传递, 传递body正文
        if (!Objects.isNull(httpRequestEntity.getBody())) {
            InputStream inputStream = new ByteArrayInputStream(httpRequestEntity.getBody());
            return new InputStreamEntity(inputStream, httpRequestEntity.getBody().length);
        }
        return null;
    }
}
