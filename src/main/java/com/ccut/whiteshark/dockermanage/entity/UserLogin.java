package com.ccut.whiteshark.dockermanage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/3 1:04 上午
 */
@Entity
@Table
public class UserLogin {
    @Id
    private String userName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String authority;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public UserLogin(String userName, String email, String password, String authority) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authority = authority;
    }

    public UserLogin() {
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
