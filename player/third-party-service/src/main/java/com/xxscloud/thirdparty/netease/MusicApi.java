package com.xxscloud.thirdparty.netease;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.xxscloud.core.JsonUtils;
import com.xxscloud.core.data.HttpResponseEntity;
import com.xxscloud.thirdparty.data.*;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 网易云音乐API接口
 */
public class MusicApi extends BaseMusicApi {

    private static HashMap<String, String> HEADER;
    private static Invocable INVOCABLE;
    private static int SUCCEED_CODE = 200;

    static {
        HEADER = new HashMap<>();
        HEADER.put("Cache-Control", "no-cache");
        HEADER.put("Connection", "keep-alive");
        HEADER.put("Origin", "http://music.163.com");
        HEADER.put("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3");
        HEADER.put("DNT", "1");
        HEADER.put("Pragma", "no-cache");
        HEADER.put("Content-Type", "application/x-www-form-urlencoded");

        try {
            byte[] cache = Files.readAllBytes(Paths.get("D:\\code\\xxscloud_node\\com.xxscloud.core\\src\\main\\resources\\core.js"));
            String js = new String(cache);
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
            scriptEngine.eval(js);
            INVOCABLE = (Invocable) scriptEngine;
        } catch (IOException | ScriptException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Nullable
    public SongInfoDto getSongInfo(final String id) {
        return null;
    }

    /**
     * 获得歌词数据.
     *
     * @param id 歌曲Id
     * @return 歌词数据
     */
    @Override
    @Nullable
    public LyricsDto getLyrics(final String id) {
        HttpResponseEntity httpResponseEntity = get("https://music.163.com/api/song/lyric?os=pc&id=" + id + "&lv=-1&kv=-1&tv=-1");
        if (!httpResponseEntity.getSucceed()) {
            return null;
        }
        LyricsDto lyricsDto = JsonUtils.toObject(httpResponseEntity.getBodyString(), LyricsDto.class);
        if (!Objects.equals(lyricsDto.getCode(), SUCCEED_CODE)) {
            return null;
        }
        return lyricsDto;
    }

    /**
     * 获得播放地址.
     *
     * @param id 歌曲Id
     * @return 播放地址
     */
    @Override
    @Nullable
    public PlayAddressDto getPlayAddress(@NotNull final String id) {
        final String json = "{\"ids\":[" + id + "], \"br\":999000, \"csrf_token\":\"\"}";
        HttpResponseEntity httpResponseEntity = post("https://music.163.com/weapi/song/enhance/player/url", getParam(json), HEADER);
        if (!httpResponseEntity.getSucceed()) {
            return null;
        }
        PlayAddressDto playAddressDto = JsonUtils.toObject(httpResponseEntity.getBodyString(), PlayAddressDto.class);
        if (!Objects.equals(playAddressDto.getCode(), SUCCEED_CODE)) {
            return null;
        }

        return playAddressDto.getData().size() > 0 ? playAddressDto.getData().get(0) : null;
    }

    @Override
    @Nullable
    public List<SongInfoDto> getRecommendPlayList(final String userId) {
        return null;
    }

    @Override
    @Nullable
    public List<PlayListDto> getMyPlayList(final String userId) {
        return null;
    }

    /**
     * 搜索歌曲
     *
     * @param name 搜索内容
     * @return 搜索结果.
     */
    @Override
    @Nullable
    public SearchResultDto search(@NotNull final String name, final int limit, final int index) {
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("s", name);
        parameter.put("limit", limit);
        parameter.put("type", 1);
        parameter.put("offset", index);
        HttpResponseEntity httpResponseEntity = post("https://music.163.com/api/search/pc", parameter, HEADER);
        if (!httpResponseEntity.getSucceed()) {
            return null;
        }
        SearchResultDto playAddressDto = JsonUtils.toObject(httpResponseEntity.getBodyString(), SearchResultDto.class);
        if (!Objects.equals(playAddressDto.getCode(), SUCCEED_CODE)) {
            return null;
        }
        return playAddressDto;
    }

    /**
     * 获得推荐歌单.
     *
     * @return 歌单列表
     */
    @Override
    public List<PlayListDto> getSystemRecommendPlayList() {
        HttpResponseEntity httpResponseEntity = get("https://music.163.com/discover");
        if (!httpResponseEntity.getSucceed()) {
            return null;
        }

        List<PlayListDto> playListDtoList = new ArrayList<>();
        Document document = Jsoup.parse(httpResponseEntity.getBodyString());
        Elements elements = document.select("#discover-module > div.g-mn1 > div > div > div:nth-child(1) > ul li");
        for (Element element : elements) {
            Elements image = element.select("img");
            String url = image.attr("src");
            Elements a = element.select("a");
            String title = a.attr("title");
            if (Objects.isNull(url) || url.equals("") || Objects.isNull(title) || title.equals("")) {
                return null;
            }
            playListDtoList.add(new PlayListDto(title, url));
        }
        return playListDtoList;
    }


    @Nullable
    private static HashMap<String, Object> getParam(String json) {
        try {
            ScriptObjectMirror scriptObjectMirror = (ScriptObjectMirror) INVOCABLE.invokeFunction("myFunc", json);
            HashMap<String, Object> param = new HashMap<>();
            param.put("params", scriptObjectMirror.get("encText").toString());
            param.put("encSecKey", scriptObjectMirror.get("encSecKey").toString());
            return param;
        } catch (ScriptException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
