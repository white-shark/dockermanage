package com.ccut.whiteshark.dockermanage.entity;

/**
 * @Author WeiPeng
 * @Date 2021/4/2 17:03
 * @Version 1.0
 */
public class HostEntity {
    private String systemTime;
    private String id;
    private Integer containersRunning;
    private String operatingSystem;
    private String architecture;
    private String serverVersion;
    private String memTotal;
    private Integer cpu;

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getContainersRunning() {
        return containersRunning;
    }

    public void setContainersRunning(Integer containersRunning) {
        this.containersRunning = containersRunning;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public String getMemTotal() {
        return memTotal;
    }

    public void setMemTotal(String memTotal) {
        this.memTotal = memTotal;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "HostEntity{" +
                "systemTime='" + systemTime + '\'' +
                ", id='" + id + '\'' +
                ", containersRunning=" + containersRunning +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", architecture='" + architecture + '\'' +
                ", serverVersion='" + serverVersion + '\'' +
                ", memTotal='" + memTotal + '\'' +
                ", cpu=" + cpu +
                '}';
    }
}
