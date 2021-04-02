package com.ccut.whiteshark.dockermanage.client.docker;

import ch.qos.logback.classic.Logger;
import com.ccut.whiteshark.dockermanage.api.http.Get;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import org.json.JSONObject;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.ParseException;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/3/27 5:56 下午
 */
public class Test {
    private static final Logger logger = null;
    public static void main(String[] args) throws ParseException {
//        DockerConfig config = new DockerConfig();
//        HttpClient httpClient = new HttpClient();
//        DockerClient dockerClient = httpClient.client(config);
//        Info info = dockerClient.infoCmd().exec();
//        JSONObject jsonObject = new JSONObject(dockerClient.versionCmd().exec());
//        System.out.println("version:"+jsonObject.toString());
//        JSONObject jsonObject7 = new JSONObject(dockerClient.infoCmd().exec());
//        System.out.println("info"+jsonObject7.toString());

        Integer a = 15326425;
        float b = a / 1000;
        System.out.println();

    }
}
