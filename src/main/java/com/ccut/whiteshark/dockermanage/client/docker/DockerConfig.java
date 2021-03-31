package com.ccut.whiteshark.dockermanage.client.docker;

import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;

/**
 * @author whiteshark
 */
public class DockerConfig {
    private static String registryUser = "whiteshark520";
    private static String registryPass = "zx12as45q.";
    private static String registryMail = "727789136@qq.com";
    private static String registryUrl = "https://hub.docker.com/";
    private static String host = "tcp://192.168.124.16:2375";
    public DockerClientConfig config(){
        DockerClientConfig custom = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost(host)
                .withDockerTlsVerify(false)
                .withRegistryUsername(registryUser)
                .withRegistryPassword(registryPass)
                .withRegistryEmail(registryMail)
                .withRegistryUrl(registryUrl)
                .build();
        return custom;
    }


}
