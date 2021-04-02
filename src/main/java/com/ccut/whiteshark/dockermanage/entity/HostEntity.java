package com.ccut.whiteshark.dockermanage.entity;

/**
 * @Author WeiPeng
 * @Date 2021/4/2 17:03
 * @Version 1.0
 */
public class HostEntity {
    private String SystemTime;
    private String Id;
    private Integer ContainersRunning;
    private String OperatingSystem;
    private String Architecture;
    private String ServerVersion;
    private String MemTotal;
    private Integer NCpu;

    public String getSystemTime() {
        return SystemTime;
    }

    public void setSystemTime(String systemTime) {
        SystemTime = systemTime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Integer getContainersRunning() {
        return ContainersRunning;
    }

    public void setContainersRunning(Integer containersRunning) {
        ContainersRunning = containersRunning;
    }

    public String getOperatingSystem() {
        return OperatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        OperatingSystem = operatingSystem;
    }

    public String getArchitecture() {
        return Architecture;
    }

    public void setArchitecture(String architecture) {
        Architecture = architecture;
    }

    public String getServerVersion() {
        return ServerVersion;
    }

    public void setServerVersion(String serverVersion) {
        ServerVersion = serverVersion;
    }

    public String getMemTotal() {
        return MemTotal;
    }

    public void setMemTotal(String memTotal) {
        MemTotal = memTotal;
    }

    public Integer getNCpu() {
        return NCpu;
    }

    public void setNCpu(Integer NCpu) {
        this.NCpu = NCpu;
    }

    @Override
    public String toString() {
        return "HostInfo{" +
                "SystemTime='" + SystemTime + '\'' +
                ", Id='" + Id + '\'' +
                ", ContainersRunning=" + ContainersRunning +
                ", OperatingSystem='" + OperatingSystem + '\'' +
                ", Architecture='" + Architecture + '\'' +
                ", ServerVersion='" + ServerVersion + '\'' +
                ", MemTotal=" + MemTotal +
                ", NCpu=" + NCpu +
                '}';
    }
}
