package com.ccut.whiteshark.dockermanage.entity;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/2 12:25 下午
 */
public class CreatConVO {
    private String containerName;
    private String ip;
    private String imageName;
    private String conPort;
    private String hostPort;
    private String conPath;
    private String hostPath;

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getConPort() {
        return conPort;
    }

    public void setConPort(String conPort) {
        this.conPort = conPort;
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    public String getConPath() {
        return conPath;
    }

    public void setConPath(String conPath) {
        this.conPath = conPath;
    }

    public String getHostPath() {
        return hostPath;
    }

    public void setHostPath(String hostPath) {
        this.hostPath = hostPath;
    }

    public CreatConVO() {
    }

    public CreatConVO(String containerName, String ip, String imageName, String conPort, String hostPort, String conPath, String hostPath) {
        this.containerName = containerName;
        this.ip = ip;
        this.imageName = imageName;
        this.conPort = conPort;
        this.hostPort = hostPort;
        this.conPath = conPath;
        this.hostPath = hostPath;
    }

    @Override
    public String toString() {
        return "CreatConVO{" +
                "containerName='" + containerName + '\'' +
                ", ip='" + ip + '\'' +
                ", imageName='" + imageName + '\'' +
                ", conPort='" + conPort + '\'' +
                ", hostPort='" + hostPort + '\'' +
                ", conPath='" + conPath + '\'' +
                ", hostPath='" + hostPath + '\'' +
                '}';
    }
}
