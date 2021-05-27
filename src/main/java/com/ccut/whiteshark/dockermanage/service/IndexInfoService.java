package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.service.impl.HostInfoServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/3 11:46 下午
 */
public interface IndexInfoService {

    public JSONObject getInfo(List<UserHost> userHosts);

}
