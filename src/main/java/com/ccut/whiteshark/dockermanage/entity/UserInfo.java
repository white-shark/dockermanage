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
    private String email;
    @Column
    private String dockerHub;
    @Column
    private String authority;
    @Column
    private String registryUser;
    @Column
    private String registryPass;
    @Column
    private String registryMail;
    @Column
    private String privateRegistry;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getDockerHub() {
        return dockerHub;
    }

    public void setDockerHub(String dockerHub) {
        this.dockerHub = dockerHub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
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

    public String getPrivateRegistry() {
        return privateRegistry;
    }

    public void setPrivateRegistry(String privateRegistry) {
        this.privateRegistry = privateRegistry;
    }

    public UserInfo(String userName, String email, String dockerHub, String authority, String registryUser, String registryPass, String registryMail, String privateRegistry) {
        this.userName = userName;
        this.email = email;
        this.dockerHub = dockerHub;
        this.authority = authority;
        this.registryUser = registryUser;
        this.registryPass = registryPass;
        this.registryMail = registryMail;
        this.privateRegistry = privateRegistry;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", dockerHub='" + dockerHub + '\'' +
                ", authority='" + authority + '\'' +
                ", registryUser='" + registryUser + '\'' +
                ", registryPass='" + registryPass + '\'' +
                ", registryMail='" + registryMail + '\'' +
                ", privateRegistry='" + privateRegistry + '\'' +
                '}';
    }
}
