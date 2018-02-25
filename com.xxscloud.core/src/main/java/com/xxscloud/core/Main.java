package com.xxscloud.core;


import com.xxscloud.core.data.HttpResponseEntity;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import jdk.nashorn.internal.runtime.ScriptObject;
import org.omg.CORBA.DynAnyPackage.Invalid;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * 测试类.
 */
public class Main {


    public static void main(String[] args) throws IOException, ScriptException, NoSuchMethodException {
        String json = "{\"id\":\"28456671\", \"total\":\"True\", \"offset\": 0, \"csrf_token\":\"nothing\", \"limit\":100, \"n\":1000}";


        HttpApiUtils httpApiUtils = new HttpApiUtils();
        HashMap<String, String> header = new HashMap<>();
        header.put("Cache-Control", "no-cache");
        header.put("Connection", "keep-alive");
        header.put("Origin", "http://music.163.com");
        header.put("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3");
        header.put("DNT", "1");
        header.put("Pragma", "no-cache");
        header.put("Content-Type", "application/x-www-form-urlencoded");

        //获得最新评论
        HttpResponseEntity httpResponseEntity = httpApiUtils.post("https://music.163.com/weapi/v1/resource/comments/A_PL_0_28456671?csrf_token=", getParam(json), header);
        System.out.println(httpResponseEntity.getBodyString());

        //读取歌单列表数据
//        httpResponseEntity = httpApiUtils.get("https://music.163.com/playlist?id=502844909");
//        if (httpResponseEntity.getBodyString().indexOf("ピロートーク") > -1) {
//            System.out.println("123");
//        }


        //获得播放列表
//        json = "{\"ids\":[499274178], \"br\":999000, \"csrf_token\":\"\"}";
//        httpResponseEntity = httpApiUtils.post("https://music.163.com/weapi/song/enhance/player/url", getParam(json), header);
//        System.out.println(httpResponseEntity.getBodyString());

        //获得歌词
//        httpResponseEntity = httpApiUtils.get("https://music.163.com/api/song/lyric?os=pc&id=" + 499274178 + "&lv=-1&kv=-1&tv=-1");
//        System.out.println(httpResponseEntity.getBodyString());


        //
        //        json = "{\"ids\":[499274178], \"br\":999000, \"csrf_token\":\"\"}";
//        httpResponseEntity = httpApiUtils.post("https://music.163.com/weapi/song/enhance/player/url", getParam(json), header);
//        System.out.println(httpResponseEntity.getBodyString());


    }

    private static HashMap<String, Object> getParam(String json) throws IOException, ScriptException, NoSuchMethodException {
        byte[] s = Files.readAllBytes(Paths.get("D:\\code\\xxscloud_node\\com.xxscloud.core\\src\\main\\resources\\core.js"));
        String js = new String(s);
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        scriptEngine.eval(js);
        Invocable invocable = (Invocable) scriptEngine;
        ScriptObjectMirror scriptObjectMirror = (ScriptObjectMirror) invocable.invokeFunction("myFunc", json);


        HashMap<String, Object> param = new HashMap<>();
        param.put("params", scriptObjectMirror.get("encText").toString());
        param.put("encSecKey", scriptObjectMirror.get("encSecKey").toString());

        return param;
    }


}


