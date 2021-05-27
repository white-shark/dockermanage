package com.ccut.whiteshark.dockermanage.api;

import com.ccut.whiteshark.dockermanage.api.http.Delete;
import com.ccut.whiteshark.dockermanage.api.http.Get;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/10 11:42 下午
 */
public class ImageUtils {
    private static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);

    public String getInamgeList(String ip,String port){
        String url = "http://" + ip + ":" + port + "/images/json";
        return Get.getInfo(url);
    }
    public JSONArray getJson(String ip,String port){
        JSONArray array = new JSONArray(getInamgeList(ip,port));
        return array;
    }

    public static JSONObject deleteImage(String ip, String port, String id){
        String url = "http://" + ip + ":" + port + "/images/" + id;
        logger.info(url);
        return Delete.delete(url);
    }


}
