package com.ccut.whiteshark.dockermanage.client.docker;

import ch.qos.logback.classic.Logger;
import com.ccut.whiteshark.dockermanage.api.ImageUtils;
import com.ccut.whiteshark.dockermanage.api.http.Get;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.ListImagesCmd;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.api.model.SearchItem;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.PullImageResultCallback;
import com.github.dockerjava.transport.DockerHttpClient;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Closeable;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/3/27 5:56 下午
 */
public class Test {
    private static final Logger logger = null;

    public static void main(String[] args) throws ParseException, IOException {
        DockerConfig config = new DockerConfig();
        HttpClient httpClient = new HttpClient();
        DockerClient dockerClient = httpClient.client(config);
//        Info info = dockerClient.infoCmd().exec();

//        ListImagesCmd client;
//        client = dockerClient.listImagesCmd();
//        System.out.println(client.toString());
        List<SearchItem> list = dockerClient.searchImagesCmd("tomcata").exec();
        System.out.println(list.toString());
        JSONArray array = new JSONArray(list);
        System.out.println(array.toString());

//        System.out.println(dockerClient.listImagesCmd().withShowAll(true).exec());
//        dockerClient.authCmd().exec();
//        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("username","whiteshark520");
//        jsonObject.put("password","zx12as45q.");
//        RequestBody body = RequestBody.create(mediaType,jsonObject.toString());
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//        Request request = new Request.Builder()
//                .post(body)
//                .url("https://hub.docker.com/v2/users/login")
//                .build();
//        Response response = client.newCall(request).execute();
//        System.out.println(response.body().string());
//
//        dockerClient.removeImageCmd("busybox").exec();
//        System.out.println("删除完毕");
//
//        DockerClient dockerClient1 = DockerClientBuilder.getInstance("tcp://192.168.124.16:2375").build();
//        AuthConfig authConfig = new AuthConfig();
//        authConfig.withUsername("whiteshark520").withPassword("zx12as45q.").withEmail("727789136@qq.com");
//        dockerClient.pullImageCmd("tomcat:latest").exec(new ResultCallback<PullResponseItem>() {
//            @Override
//            public void onStart(Closeable closeable) {
//                System.out.println("开始下载!");
//            }
//
//            @Override
//            public void onNext(PullResponseItem pullResponseItem) {
//                System.out.println(pullResponseItem.getStatus());
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                throwable.printStackTrace();
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("下载完毕!");
//            }
//
//            @Override
//            public void close() throws IOException {
//
//            }
//        });
//
//
//
//        dockerClient.pullImageCmd("busybox:latest").exec(new PullImageResultCallback()).awaitSuccess();
//        System.out.println("下载完毕!");
//


    }
}
