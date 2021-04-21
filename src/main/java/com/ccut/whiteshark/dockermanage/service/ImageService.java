package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.api.ImageUtils;
import com.ccut.whiteshark.dockermanage.entity.ImageEntity;
import com.ccut.whiteshark.dockermanage.entity.UserHost;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
}
