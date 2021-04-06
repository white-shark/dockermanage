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

    public UserInfo(String userName, String email, String dockerHub, String authority) {
        this.userName = userName;
        this.email = email;
        this.dockerHub = dockerHub;
        this.authority = authority;
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
                '}';
    }
}
