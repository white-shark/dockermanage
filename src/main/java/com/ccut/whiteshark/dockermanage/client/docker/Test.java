package com.ccut.whiteshark.dockermanage.client.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DockerClientImpl;
import org.json.JSONObject;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/3/27 5:56 下午
 */
public class Test {
    public static void main(String[] args) {
        Config config = new Config();
        HttpClient httpClient = new HttpClient();
        DockerClient dockerClient = httpClient.client();
//        dockerClient.pingCmd().exec();
        Info info = dockerClient.infoCmd().exec();
        JSONObject jsonObject = new JSONObject(info);
        System.out.println(jsonObject.toString());
    }
}
