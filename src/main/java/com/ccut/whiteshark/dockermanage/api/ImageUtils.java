package com.ccut.whiteshark.dockermanage.api;

import com.ccut.whiteshark.dockermanage.api.http.Get;
import org.json.JSONArray;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/10 11:42 下午
 */
public class ImageUtils {

    public String getInamgeList(String ip,String port){
        String url = "http://" + ip + ":" + port + "/images/json";
        return Get.getInfo(url);
    }
    public JSONArray getJson(String ip,String port){
        JSONArray array = new JSONArray(getInamgeList(ip,port));
        return array;
    }

}
