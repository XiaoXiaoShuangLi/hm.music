package com.xxscloud.thirdparty.service;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.xxscloud.thirdparty.data.*;

import java.util.List;

/**
 * @author 李小双 2018.2.22
 * 第三放音乐服务器层.
 */
public interface MusicService {

    /**
     * 获得每日推荐的数据.
     *
     * @return 推荐数据.
     */
    TodayRecommendationDto getTodayRecommendation();


    /**
     * 获得歌曲信息.
     *
     * @param id 歌曲Id
     * @return 歌曲信息
     */
    @Nullable
    SongInfoDto getSongInfo(@NotNull final String id);

    /**
     * 获得歌词.
     *
     * @param id 歌曲Id
     * @return 歌词信息等
     */
    @Nullable
    LyricsDto getLyrics(@NotNull final String id);

    /**
     * 获得播放地址.
     *
     * @param id 歌曲Id
     * @return 播放地址
     */
    @Nullable
    PlayAddressDto getPlayAddress(@NotNull final String id);


    /**
     * 获得每日推荐歌单列表.
     * <b>获取执行时间偏长建议做缓存</b>
     *
     * @return 播放地址
     */
    @Nullable
    List<SongInfoDto> getRecommendPlayList(@NotNull final String userId);


    /**
     * 获得我的歌单.
     * <b>获取执行时间偏长建议做缓存</b>
     *
     * @return 歌单
     */
    @Nullable
    List<PlayListDto> getMyPlayList(@NotNull final String userId);

    /**
     * 搜索歌曲.
     *
     * @param name  搜索内容
     * @param limit 每页显示条数
     * @param index 第几页
     * @return 搜索结果
     */
    @Nullable
    SearchResultDto search(@NotNull final String name, final int limit, final int index);

    /**
     * 获得系统推荐歌曲.
     *
     * @return 推荐歌单列表
     */
    @Nullable
    List<PlayListDto> getSystemRecommendPlayList();
}
