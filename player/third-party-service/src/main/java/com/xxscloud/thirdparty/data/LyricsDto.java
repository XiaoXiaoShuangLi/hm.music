package com.xxscloud.thirdparty.data;

public class LyricsDto extends NetEaseMusicResponseEntity<LyricsDto> {

    /**
     * id 数据.
     */
    private String id;

    /**
     * 歌词提供者.
     */
    private String nickname;

    /**
     * 歌词实体
     */
    private LyricsDto lrc;

    /**
     * 歌词信息.
     */
    private String lyric;

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
     * 获取 nickname .
     *
     * @return nickname 数据
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置 nickname .
     *
     * @param nicknameValue 设置 nickname .
     */
    public void setNickname(final String nicknameValue) {
        nickname = nicknameValue;
    }

    /**
     * 获取 lrc .
     *
     * @return lrc 数据
     */
    public LyricsDto getLrc() {
        return lrc;
    }

    /**
     * 设置 lrc .
     *
     * @param lrcValue 设置 lrc .
     */
    public void setLrc(final LyricsDto lrcValue) {
        lrc = lrcValue;
    }

    /**
     * 获取 lyric .
     *
     * @return lyric 数据
     */
    public String getLyric() {
        return lyric;
    }

    /**
     * 设置 lyric .
     *
     * @param lyricValue 设置 lyric .
     */
    public void setLyric(final String lyricValue) {
        lyric = lyricValue;
    }
}
