package com.ccut.whiteshark.dockermanage.api.http;

import okhttp3.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/3/31 10:52 下午
 */
public class Post {
    private static final Logger logger = LoggerFactory.getLogger(Post.class);
    public static MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static String getInfo(String url){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .callTimeout(60, TimeUnit.SECONDS)
                .pingInterval(5, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        JSONObject jsonObject = new JSONObject();
        RequestBody body = RequestBody.create(JSON,jsonObject.toString());
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            logger.warn("请求" + url + "失败！");
        }

        return url;
    }
}
