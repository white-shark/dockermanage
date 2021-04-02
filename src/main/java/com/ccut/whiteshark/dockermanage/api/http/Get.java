package com.ccut.whiteshark.dockermanage.api.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/3/31 10:52 下午
 */
public class Get {
    public static String getInfo(String url){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return url;
    }
}
