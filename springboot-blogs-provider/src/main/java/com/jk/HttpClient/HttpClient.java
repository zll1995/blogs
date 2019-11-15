package com.jk.HttpClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.utils.HttpClientUtil;

import java.util.HashMap;

/**
 * @ClassName HttpClient
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/15 9:47
 * @Version V1.0
 * (此类只用来调用外网接口)
 **/
public class HttpClient {
    /**
     * DailySentence每日一句接口使用说明
     *.date:当前日期
     * .note:一句话
     * .content:英文版
     * .translation:小编的话
     * @return
     */
    public static HashMap<String, Object> DailySentence(){
        String url = "http://open.iciba.com/dsapi/";
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("a",11);
        String string = HttpClientUtil.post(url, map);
        JSONObject jo = JSON.parseObject(string);
        HashMap<String,Object> map1 = new HashMap<String,Object>();
        map1.put("date",jo.get("dateline"));
        map1.put("note",jo.get("note"));
        map1.put("content",jo.get("content"));
        map.put("translation",jo.get("translation"));
        return map1;
    }
}
