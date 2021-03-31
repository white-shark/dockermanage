package com.ccut.whiteshark.dockermanage.client.docker;

import com.ccut.whiteshark.dockermanage.api.http.GetInfo;
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
//        DockerConfig config = new DockerConfig();
//        HttpClient httpClient = new HttpClient();
//        DockerClient dockerClient = httpClient.client(config);
//        Info info = dockerClient.infoCmd().exec();
//        JSONObject jsonObject = new JSONObject(dockerClient.versionCmd().exec());
//        System.out.println(jsonObject.toString());
        String url = "http://192.168.124.16:2375/containers/json";
        GetInfo getInfo = new GetInfo();
        String result = getInfo.getInfo(url);
        System.out.println(result);
    }
}
