package com.ccut.whiteshark.dockermanage.api;

import com.ccut.whiteshark.dockermanage.api.http.Get;

/**
 * @Author WeiPeng
 * @Date 2021/4/2 16:50
 * @Version 1.0
 */
public class HostInfo {
    public String getHostInfo(String ip, String port){
        String url ="http://" + ip + ":" + port + "/info";
        return Get.getInfo(url);
    }
}
