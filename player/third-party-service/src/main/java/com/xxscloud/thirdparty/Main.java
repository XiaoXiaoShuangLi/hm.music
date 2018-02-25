package com.xxscloud.thirdparty;

import com.xxscloud.core.JsonUtils;
import com.xxscloud.thirdparty.data.PlayListDto;
import com.xxscloud.thirdparty.netease.MusicApi;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        MusicApi musicApi = new MusicApi();

        //测试获得播放地址
//        PlayAddressDto playAddressDto = musicApi.getPlayAddress("496870798");
//        System.out.println(JsonUtils.toJson(playAddressDto));


        //测试歌曲的歌词
//        LyricsDto lyricsDto = musicApi.getLyrics("496870798");
//        System.out.println(JsonUtils.toJson(lyricsDto));

        //测试搜索
//        SearchResultDto searchResultDto =  musicApi.search("I MISS YOU", 30, 0);
//        System.out.println(JsonUtils.toJson(searchResultDto));

        // 推荐歌单
        List<PlayListDto> playListDtoList = musicApi.getSystemRecommendPlayList();
        System.out.println(JsonUtils.toJson(playListDtoList));
    }
}
