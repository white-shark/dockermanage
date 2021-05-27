package com.ccut.whiteshark.dockermanage.client.docker;

import ch.qos.logback.classic.Logger;
import com.ccut.whiteshark.dockermanage.exception.MinimesosException;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.LogContainerCmd;
import com.github.dockerjava.api.model.*;
import com.github.dockerjava.core.command.LogContainerResultCallback;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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
//        List<SearchItem> list = dockerClient.searchImagesCmd("tomcata").exec();
//        System.out.println(list.toString());
//        JSONArray array = new JSONArray(list);
//        System.out.println(array.toString());

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
        AuthConfig authConfig = new AuthConfig();
        authConfig.withUsername("whiteshark520").withPassword("zx12as45q.").withEmail("727789136@qq.com");
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
//        try {
//            dockerClient.pullImageCmd("nginx:latest").exec(new PullImageResultCallback()).awaitCompletion();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        PortBinding portBinding = PortBinding.parse("8080:8080");
//        PortBinding portBinding1 = PortBinding.parse("8081:8081");
//
//        Volume volume1 = new Volume("/app/tomcat");
//        List<PortBinding> list = new ArrayList<>();
//        list.add(portBinding);
//        list.add(portBinding1);
//        HostConfig hostConfig = HostConfig.newHostConfig()
//                .withPortBindings(list)
//                .withBinds(new Bind("/usr/local/docker/tomcat/webapps/ROOT", volume1));
//
//        try {
//            CreateContainerResponse response = dockerClient.createContainerCmd("tomcat")
//                    .withName("tomcat2")
//                    .withHostConfig(hostConfig)
//                    .withExposedPorts(ExposedPort.parse("8080" + "/tcp"))
////                    .withVolumes(Volume.parse(map))
//                    .exec();
//            System.out.println(response.getId());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        dockerClient.startContainerCmd("").exec();

        String containerId = "22589f35d0d29cded745c0df7dcfa604e59677faead55a67162993f432435d45";

        final List<String> logs = new ArrayList<>();

        LogContainerCmd logContainerCmd = dockerClient.logContainerCmd(containerId);
        logContainerCmd.withStdOut(true).withStdErr(true);
        try {
            logContainerCmd.exec(new LogContainerResultCallback() {
                @Override
                public void onNext(Frame item) {
                    logs.add(item.toString());
                }
            }).awaitCompletion();
        } catch (InterruptedException e) {
            throw new MinimesosException("Failed to retrieve logs of container " + containerId, e);
        }

        System.out.println("日志");
        for (int i = 0; i < logs.size();i++){
            System.out.println(logs.get(i));
        }
    }
}
