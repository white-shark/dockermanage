package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.api.ImageUtils;
import com.ccut.whiteshark.dockermanage.client.docker.DockerConfig;
import com.ccut.whiteshark.dockermanage.client.docker.HttpClient;
import com.ccut.whiteshark.dockermanage.entity.ImageEntity;
import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.api.model.SearchItem;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/3 11:44 下午
 */
public interface ImageService {

    public JSONArray getImageList(List<UserHost> list) ;

    public String deleteImage(String ip,String port,String id);

    public JSONArray searchImage(String ip, String port, UserInfo userInfo, String imageName);

    public String pullImage(String ip, String port, UserInfo userInfo, String imageName);
}
