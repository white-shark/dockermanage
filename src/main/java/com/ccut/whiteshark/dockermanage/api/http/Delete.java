package com.ccut.whiteshark.dockermanage.api.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/24 1:34 下午
 */
public class Delete {

    private static final Logger logger = LoggerFactory.getLogger(Delete.class);
    public static JSONObject delete(String url){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .callTimeout(60, TimeUnit.SECONDS)
                .pingInterval(5, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .delete()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject result = new JSONObject();
            result.put("code",response.code());
            result.put("data",response.body().string());
            return result;
        } catch (IOException e) {
            JSONObject result = new JSONObject();
            result.put("code",500);
            result.put("data","请求" + url + "失败！");
            logger.warn("请求" + url + "失败！");
            return result;
        }
    }
}
