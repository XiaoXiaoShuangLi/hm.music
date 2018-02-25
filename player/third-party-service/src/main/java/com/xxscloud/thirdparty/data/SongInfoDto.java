package com.xxscloud.thirdparty.data;

import java.util.List;

public class SongInfoDto extends NetEaseMusicResponseEntity {

    /**
     * 歌曲Id.
     */
    private String id;

    /**
     * 歌曲名称.
     */
    private String name;

    /**
     * 其他Id.
     */
    private String commentThreadId;

    /**
     * 艺术家.
     */
    private List<ArtistsInfoDto> artists;


    /**
     * 获取 id .
     *
     * @return id 数据
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 id .
     *
     * @param idValue 设置 id .
     */
    public void setId(final String idValue) {
        id = idValue;
    }

    /**
     * 获取 name .
     *
     * @return name 数据
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name .
     *
     * @param nameValue 设置 name .
     */
    public void setName(final String nameValue) {
        name = nameValue;
    }

    /**
     * 获取 commentThreadId .
     *
     * @return commentThreadId 数据
     */
    public String getCommentThreadId() {
        return commentThreadId;
    }

    /**
     * 设置 commentThreadId .
     *
     * @param commentThreadIdValue 设置 commentThreadId .
     */
    public void setCommentThreadId(final String commentThreadIdValue) {
        commentThreadId = commentThreadIdValue;
    }

    /**
     * 获取 artists .
     *
     * @return artists 数据
     */
    public List<ArtistsInfoDto> getArtists() {
        return artists;
    }

    /**
     * 设置 artists .
     *
     * @param artistsValue 设置 artists .
     */
    public void setArtists(final List<ArtistsInfoDto> artistsValue) {
        artists = artistsValue;
    }
}
