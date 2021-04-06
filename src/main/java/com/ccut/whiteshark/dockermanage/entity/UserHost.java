package com.ccut.whiteshark.dockermanage.entity;

import javax.persistence.*;

/**
 * @Author WeiPeng
 * @Date 2021/4/6 14:43
 * @Version 1.0
 */
@Entity
@Table
public class UserHost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column
    private String userName;
    @Column
    private String host;
    @Column
    private String port;
    @Column
    private String hostName;

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

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserHost(Integer id, String userName, String host, String port, String hostName) {
        this.id = id;
        this.userName = userName;
        this.host = host;
        this.port = port;
        this.hostName = hostName;
    }

    public UserHost() {
    }

    @Override
    public String toString() {
        return "UserHost{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", hostName='" + hostName + '\'' +
                '}';
    }
}
