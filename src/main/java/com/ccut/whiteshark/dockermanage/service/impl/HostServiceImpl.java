package com.ccut.whiteshark.dockermanage.service.impl;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.repository.UserHostRepository;
import com.ccut.whiteshark.dockermanage.service.HostService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/29 12:35 上午
 */
@Service
public class HostServiceImpl implements HostService {

    @Autowired
    UserHostRepository repository;

    @Override
    public JSONArray getIpList(String userName){
        List<UserHost> list = repository.findAllByUserName(userName);
        JSONArray result = new JSONArray();
        for (UserHost userHost : list){
            result.put(userHost.getHost());
        }
        return result;
    }

}
