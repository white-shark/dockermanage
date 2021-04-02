package com.ccut.whiteshark.dockermanage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/3 12:59 上午
 */
@Entity
@Table
public class UserInfo {
    @Id
    private String userName;
    @Column
    private String host;
    @Column
    private String port;
    @Column
    private String dockerHub;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDockerHub() {
        return dockerHub;
    }

    public void setDockerHub(String dockerHub) {
        this.dockerHub = dockerHub;
    }

    public UserInfo(String userName, String host, String port, String dockerHub) {
        this.userName = userName;
        this.host = host;
        this.port = port;
        this.dockerHub = dockerHub;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", dockerHub='" + dockerHub + '\'' +
                '}';
    }
}
