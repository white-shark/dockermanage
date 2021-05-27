package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import org.json.JSONArray;

import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/3 11:42 下午
 */
public interface HostInfoService {

    public JSONArray getHostInfo(List<UserHost> list);
}
