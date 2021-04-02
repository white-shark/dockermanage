package com.ccut.whiteshark.dockermanage.api;

import com.ccut.whiteshark.dockermanage.api.http.Get;

/**
 * @Author WeiPeng
 * @Date 2021/4/2 16:40
 * @Version 1.0
 */
public class Stats {
    public String getStats(String ip, String port, String id){
        String url = ip + ":" + port +"/containers/" + id + "/stats?stream=false";
        return Get.getInfo(url);

    }
}
