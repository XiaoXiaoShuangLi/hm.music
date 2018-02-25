package com.xxscloud.thirdparty.service;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.xxscloud.thirdparty.data.*;
import com.xxscloud.thirdparty.netease.MusicApi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李小双 2018.2.22
 * 音乐API服务层
 */
public class MusicImpl implements MusicService {

    private MusicApi musicApi;

    public MusicImpl(MusicApi musicApiValue) {
        musicApi = musicApiValue;
    }

    /**
     * 获得每日推荐的数据.
     *
     * @return 推荐数据.
     */
    @Override
    @Nullable
    public TodayRecommendationDto getTodayRecommendation() {
        TodayRecommendationDto todayRecommendationDto = new TodayRecommendationDto();
        List<BannerDto> bannerDtoList = new ArrayList<>();
        bannerDtoList.add(new BannerDto("https://y.gtimg.cn/music/photo_new/T003R720x288M0000049UDes0oykTn.jpg?max_age=2592000", ""));
        bannerDtoList.add(new BannerDto("https://y.gtimg.cn/music/photo_new/T003R720x288M00000009aWG0PfKWK.jpg?max_age=2592000", ""));
        bannerDtoList.add(new BannerDto("https://y.gtimg.cn/music/photo_new/T003R720x288M00000009aWG0PfKWK.jpg?max_age=2592000", ""));
        todayRecommendationDto.setBanner(bannerDtoList);
        List<BannerDto> hostDataList = new ArrayList<>();
        hostDataList.add(new BannerDto("https://y.gtimg.cn/music/photo/radio/track_radio_199_13_1.jpg?max_age=2592000", "", "每日推荐", ""));
        hostDataList.add(new BannerDto("https://y.gtimg.cn/music/photo/radio/track_radio_199_13_1.jpg?max_age=2592000", "", "新歌推荐", "朴树开口酥炸了"));
        hostDataList.add(new BannerDto("https://y.gtimg.cn/music/photo/radio/track_radio_199_13_1.jpg?max_age=2592000", "", "热门歌单", "吴奇隆新居OST上线了"));
        todayRecommendationDto.setHotData(hostDataList);
        return todayRecommendationDto;
    }

    /**
     * 获得歌曲信息.
     *
     * @param id 歌曲Id
     * @return 歌曲信息
     */
    @Override
    public SongInfoDto getSongInfo(@NotNull final String id) {
        return musicApi.getSongInfo(id);
    }

    /**
     * 获得歌词数据.
     *
     * @param id 歌曲Id
     * @return 歌词数据
     */
    @Override
    public LyricsDto getLyrics(@NotNull final String id) {
        return musicApi.getLyrics(id);
    }

    /**
     * 获得歌曲的播放地址.
     *
     * @param id 歌曲Id
     * @return 播放地址
     */
    @Override
    public PlayAddressDto getPlayAddress(@NotNull final String id) {
        return musicApi.getPlayAddress(id);
    }

    @Override
    public List<SongInfoDto> getRecommendPlayList(@NotNull final String userId) {
        return null;
    }

    @Override
    public List<PlayListDto> getMyPlayList(@NotNull final String userId) {
        return null;
    }

    @Override
    public SearchResultDto search(@NotNull final String name, @NotNull final int limit, @NotNull final int index) {
        return null;
    }

    /**
     * 获得系统推荐播放列表
     *
     * @return 播放列表
     */
    @Override
    @Nullable
    public List<PlayListDto> getSystemRecommendPlayList() {
        return musicApi.getSystemRecommendPlayList();
    }
}
