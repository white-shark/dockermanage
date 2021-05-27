package com.ccut.whiteshark.dockermanage.entity;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/30 11:06 下午
 */
public class ContainerEntity {

    private String ip;
    private String id;
    private String name;
    private String imageName;
    private String state;
    private String status;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ContainerEntity(String ip, String id, String name, String imageName, String state, String status) {
        this.ip = ip;
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.state = state;
        this.status = status;
    }

    public ContainerEntity() {
    }

    @Override
    public String toString() {
        return "ContainerEntity{" +
                "ip='" + ip + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                ", state='" + state + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
