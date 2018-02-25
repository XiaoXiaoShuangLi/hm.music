package com.xxscloud.thirdparty.data;

import java.util.List;

/**
 * @author 李小双 2018.2.2
 * 获得今日推荐的数据.
 */
public class TodayRecommendationDto {

    /**
     * 头部banner 的数据.
     */
    private List<BannerDto> banner;

    /**
     * 头部下面热门数据.
     */
    private List<BannerDto> hotData;

    /**
     * 获得banner 值.
     *
     * @return banner 值
     */
    public List<BannerDto> getBanner() {
        return banner;
    }

    /**
     * 设置新bannerValue值.
     *
     * @param bannerValue 值
     */
    public void setBanner(List<BannerDto> bannerValue) {
        banner = bannerValue;
    }

    /**
     * 获得hotData 值.
     *
     * @return hotData 值
     */
    public List<BannerDto> getHotData() {
        return hotData;
    }

    /**
     * 设置新hotDataValue值.
     *
     * @param hotDataValue 值
     */
    public void setHotData(List<BannerDto> hotDataValue) {
        hotData = hotDataValue;
    }
}
