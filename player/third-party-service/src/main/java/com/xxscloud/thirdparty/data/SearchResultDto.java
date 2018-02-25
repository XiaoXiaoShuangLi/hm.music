package com.xxscloud.thirdparty.data;

import java.util.List;

public class SearchResultDto extends NetEaseMusicResponseEntity<SearchResultDto> {

    /**
     * 搜索条数.
     */
    private int songCount;

    /**
     * 歌单信息.
     */
    private List<SongInfoDto> songs;
}
