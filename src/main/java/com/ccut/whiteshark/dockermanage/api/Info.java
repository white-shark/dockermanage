package com.ccut.whiteshark.dockermanage.api;

import com.ccut.whiteshark.dockermanage.client.docker.DockerConfig;
import com.ccut.whiteshark.dockermanage.client.docker.HttpClient;
import com.github.dockerjava.api.DockerClient;
import org.json.JSONObject;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/3/31 9:37 下午
 */
public class Info {
    public void getInfo(DockerConfig dockerConfig){
        HttpClient httpClient = new HttpClient();
        DockerClient dockerClient = httpClient.client(dockerConfig);
        com.github.dockerjava.api.model.Info info = dockerClient.infoCmd().exec();
        JSONObject result = new JSONObject(info);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Containers",result.getInt("Containers"));


    }
}
