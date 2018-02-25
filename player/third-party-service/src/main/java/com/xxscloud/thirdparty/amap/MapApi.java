package com.xxscloud.thirdparty.amap;


import com.google.gson.internal.LinkedTreeMap;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.xxscloud.core.JsonUtils;
import com.xxscloud.core.ParameterException;
import com.xxscloud.core.ToType;
import com.xxscloud.core.data.HttpResponseEntity;
import com.xxscloud.thirdparty.data.AddressDto;
import com.xxscloud.thirdparty.data.CoordinatesDto;
import sun.net.util.IPAddressUtil;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author 李小双 2018.1.28
 * 地图API接口
 */
public class MapApi extends BaseAmap {

    /**
     * KEY.
     */
    private static final String KEY = "11d9b016ce7f344ae002b3dcecc7d614";

    /**
     * 获得GPS数据.
     *
     * @param ip 网络地址
     * @return 获得经度、纬度
     */
    @Nullable
    public AddressDto getIPInfo(@NotNull final String ip) {
        if (Objects.isNull(ip) || !IPAddressUtil.isIPv4LiteralAddress(ip)) {
            throw new ParameterException("IP address error");
        }
        final String url = "http://restapi.amap.com/v3/ip?parameters";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("ip", ip);
        parameters.put("key", KEY);
        HttpResponseEntity httpResponseEntity = post(url, parameters);
        if (httpResponseEntity.getSucceed()) {
            final String resultJson = httpResponseEntity.getBodyString();
            LinkedTreeMap<String, Object> result = JsonUtils.toObject(resultJson, LinkedTreeMap.class);
            if (!Objects.equals(result.get("status").toString(), "1")) {
                return null;
            }
            LinkedTreeMap<String, Object> content = (LinkedTreeMap) result.get("content");
            AddressDto address = JsonUtils.toObject(resultJson, AddressDto.class);
            String[] rectangles = address.getRectangle().split(";")[0].split(",");
            address.setCoordinates(new CoordinatesDto(ToType.toDouble(rectangles[0]), ToType.toDouble(rectangles[0])));
            return address;
        }
        return null;
    }



    /**
     * 获得天气预报.
     *
     * @param value 城市名称或者高德地图城市代码
     * @return 今日天气
     */
    @Nullable
    public Object getWeatherInfo(@NotNull final String value) {

        return null;
    }
}

