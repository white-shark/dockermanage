package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.api.ImageUtils;
import com.ccut.whiteshark.dockermanage.client.docker.DockerConfig;
import com.ccut.whiteshark.dockermanage.client.docker.HttpClient;
import com.ccut.whiteshark.dockermanage.entity.ImageEntity;
import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.api.command.PullImageCmd;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.api.model.SearchItem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/11 12:14 上午
 */
@Service
public class ImageService {

    private static final Logger logger = LoggerFactory.getLogger(ImageService.class);
    public JSONArray getImageList(List<UserHost> list) {
        logger.info("获取镜像信息");
        ImageUtils utils = new ImageUtils();
        JSONArray result = new JSONArray();
        for (int i = 0;i < list.size();i++){
            UserHost userHost = list.get(i);
            JSONArray array = new JSONArray(utils.getInamgeList(userHost.getHost(), userHost.getPort()));
            JSONArray array1 = new JSONArray();
            for (int j = 0;j < array.length();j++){
                JSONObject jsonObject = array.getJSONObject(j);
                ImageEntity entity = new ImageEntity();
                entity.setId(jsonObject.getString("Id"));
                entity.setSize(jsonObject.getInt("Size"));
                entity.setVirtualSize(jsonObject.getInt("VirtualSize"));
                entity.setRepoTags(jsonObject.getJSONArray("RepoTags").getString(0));
                entity.setIp(userHost.getHost());
                array1.put(entity);
            }
            result.put(array1);
        }
        return result;
    }

    public String deleteImage(String ip,String port,String id){
        logger.info("删除镜像");
        try{
            JSONObject jsonObject = ImageUtils.deleteImage(ip, port, id);
            if (jsonObject.getInt("code") == 200){
                logger.info("删除镜像{"+id+"}成功！");
                return "删除成功";
            }
            else {
                JSONObject jsonObject1 = new JSONObject(jsonObject.getString("data"));
                return jsonObject1.getString("message");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除镜像失败！");
            return "error";
        }
    }

    public JSONArray searchImage(String ip, String port, UserInfo userInfo, String imageName){
//        String[] imn = imageName.split(":");
//        if (imn.length < 2){
//            imageName = imageName + ":latest";
//        }
        logger.info("搜索镜像");
        DockerConfig config = new DockerConfig();
        config.setRegistryUser(userInfo.getRegistryUser());
        config.setRegistryPass(userInfo.getRegistryPass());
        config.setRegistryMail(userInfo.getRegistryMail());
        config.setRegistryUrl(userInfo.getDockerHub());
        config.setHost("tcp://"+ ip + ":" + port);
        HttpClient httpClient = new HttpClient();
        DockerClient dockerClient = httpClient.client(config);
        List<SearchItem> list = dockerClient.searchImagesCmd(imageName).exec();
        JSONArray array = new JSONArray(list);
        return array;
    }

    public JSONArray pullImage(String ip, String port, UserInfo userInfo, String imageName) throws InterruptedException {
        DockerConfig config = new DockerConfig();
        config.setRegistryUser(userInfo.getRegistryUser());
        config.setRegistryPass(userInfo.getRegistryPass());
        config.setRegistryMail(userInfo.getRegistryMail());
        config.setRegistryUrl(userInfo.getDockerHub());
        config.setHost("tcp://"+ ip + ":" + port);
        HttpClient httpClient = new HttpClient();
        DockerClient dockerClient = httpClient.client(config);
        JSONArray jsonArray = new JSONArray();
        dockerClient.pullImageCmd(imageName).exec(new PullImageResultCallback()).awaitCompletion();
        return jsonArray.put("success");
    }


}
