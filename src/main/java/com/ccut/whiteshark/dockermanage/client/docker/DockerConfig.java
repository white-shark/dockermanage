package com.ccut.whiteshark.dockermanage.client.docker;

import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;

/**
 * @author whiteshark
 */
public class DockerConfig {
    private String registryUser = "whiteshark520";
    private String registryPass = "zx12as45q.";
    private String registryMail = "727789136@qq.com";
    private String registryUrl = "https://hub.docker.com/";
    private String host = "tcp://192.168.124.17:2375";
//    private String registryUser;
//    private String registryPass;
//    private String registryMail;
//    private String registryUrl;
//    private String host;


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

    public String getRegistryUser() {
        return registryUser;
    }

    public void setRegistryUser(String registryUser) {
        this.registryUser = registryUser;
    }

    public String getRegistryPass() {
        return registryPass;
    }

    public void setRegistryPass(String registryPass) {
        this.registryPass = registryPass;
    }

    public String getRegistryMail() {
        return registryMail;
    }

    public void setRegistryMail(String registryMail) {
        this.registryMail = registryMail;
    }

    public String getRegistryUrl() {
        return registryUrl;
    }

    public void setRegistryUrl(String registryUrl) {
        this.registryUrl = registryUrl;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
