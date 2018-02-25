package com.xxscloud.api.service;

import com.xxscloud.api.core.APIMapping;
import com.xxscloud.core.JsonUtils;
import com.xxscloud.core.data.ResultDto;
import org.springframework.stereotype.Service;


/**
 * @author 李小双 2018.2.22
 * 音乐服务.
 */
@Service
public class MusicService {

    /**
     * 获得每日推荐资讯.
     *
     * @return 处理结果.
     */
    @APIMapping(value = "api.music.getTodayRecommendationList", login = false)
    public ResultDto getTodayRecommendationList() {
        return new ResultDto(false, "succeed", "");
    }
}
