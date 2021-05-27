package com.ccut.whiteshark.dockermanage.service;

import org.json.JSONArray;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/3 11:43 下午
 */
public interface HostService {

    public JSONArray getIpList(String userName);
}
