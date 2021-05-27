package com.ccut.whiteshark.dockermanage.api;

import com.ccut.whiteshark.dockermanage.api.http.Delete;
import com.ccut.whiteshark.dockermanage.api.http.Get;
import com.ccut.whiteshark.dockermanage.api.http.Post;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/30 11:19 下午
 */
public class ContainerUtils {
    private static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);

    public static String getList(String ip,String port){
        String url = "http://" + ip + ":" + port + "/containers/json?all=true";
        return Get.getInfo(url);
    }
    public static String startContainer(String ip,String port,String id){
        String url = "http://" + ip + ":" + port + "/containers/" + id + "/start";
        return Post.getInfo(url);
    }
    public static String stopContainer(String ip,String port,String id){
        String url = "http://" + ip + ":" + port + "/containers/" + id + "/stop";
        return Post.getInfo(url);
    }
    public static JSONObject deleteContainer(String ip,String port,String id){
        String url = "http://" + ip + ":" + port + "/containers/" + id;
        return Delete.delete(url);
    }
}
