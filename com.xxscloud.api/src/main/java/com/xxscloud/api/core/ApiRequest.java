package com.xxscloud.api.core;

/**
 * @author 李小双 2018.2.22
 */
public class ApiRequest {

    /**
     * 账户.
     */
    private String account;

    /**
     * 名称.
     */
    private String name;

    /**
     * 令牌.
     */
    private String accessToken;

    /**
     * 签名.
     */
    private String sign;

    /**
     * 设备用户标示号.
     */
    private String uCode;

    /**
     * 设备标示号.
     */
    private String eCode;

    /**
     * 时间.
     */
    private long time;

    /**
     * 客户端IP.
     */
    private String clientIp;

    /**
     * 是否需要登录.
     */
    private boolean isLogin;

    /**
     * 参数.
     */
    private String params;


    /**
     * 获得account 值.
     *
     * @return account 值
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置新accountValue值.
     *
     * @param accountValue 值
     */
    public void setAccount(String accountValue) {
        account = accountValue;
    }

    /**
     * 获得name 值.
     *
     * @return name 值
     */
    public String getName() {
        return name;
    }

    /**
     * 设置新nameValue值.
     *
     * @param nameValue 值
     */
    public void setName(String nameValue) {
        name = nameValue;
    }

    /**
     * 获得accessToken 值.
     *
     * @return accessToken 值
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 设置新accessTokenValue值.
     *
     * @param accessTokenValue 值
     */
    public void setAccessToken(String accessTokenValue) {
        accessToken = accessTokenValue;
    }

    /**
     * 获得sign 值.
     *
     * @return sign 值
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置新signValue值.
     *
     * @param signValue 值
     */
    public void setSign(String signValue) {
        sign = signValue;
    }

    /**
     * 获得uCode 值.
     *
     * @return uCode 值
     */
    public String getuCode() {
        return uCode;
    }

    /**
     * 设置新uCodeValue值.
     *
     * @param uCodeValue 值
     */
    public void setuCode(String uCodeValue) {
        uCode = uCodeValue;
    }

    /**
     * 获得eCode 值.
     *
     * @return eCode 值
     */
    public String geteCode() {
        return eCode;
    }

    /**
     * 设置新eCodeValue值.
     *
     * @param eCodeValue 值
     */
    public void seteCode(String eCodeValue) {
        eCode = eCodeValue;
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

    /**
     * 获得clientIp 值.
     *
     * @return clientIp 值
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * 设置新clientIpValue值.
     *
     * @param clientIpValue 值
     */
    public void setClientIp(String clientIpValue) {
        clientIp = clientIpValue;
    }

    /**
     * 获得isLogin 值.
     *
     * @return isLogin 值
     */
    public boolean isLogin() {
        return isLogin;
    }

    /**
     * 设置新loginValue值.
     *
     * @param loginValue 值
     */
    public void setLogin(boolean loginValue) {
        isLogin = loginValue;
    }

    /**
     * 获得params 值.
     *
     * @return params 值
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置新paramsValue值.
     *
     * @param paramsValue 值
     */
    public void setParams(String paramsValue) {
        params = paramsValue;
    }
}
