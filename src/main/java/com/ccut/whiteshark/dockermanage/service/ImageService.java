package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.api.ImageUtils;
import com.ccut.whiteshark.dockermanage.entity.ImageEntity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/11 12:14 上午
 */
@Service
public class ImageService {
    public JSONArray getImageList(String ip, String port) {
        ImageUtils utils = new ImageUtils();
        JSONArray array = new JSONArray(utils.getInamgeList(ip, port));
        ImageEntity entity = new ImageEntity();
        JSONArray result = new JSONArray();
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            entity.setId(jsonObject.getString("Id"));
            JSONArray array1 = jsonObject.getJSONArray("RepoTags");
            entity.setRepoTags(array1.getString(0));
            entity.setSize(jsonObject.getInt("Size")/1024);
            result.put(entity);
        }
        return result;
    }
}
