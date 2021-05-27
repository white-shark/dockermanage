package com.ccut.whiteshark.dockermanage.service.impl;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.repository.UserHostRepository;
import com.ccut.whiteshark.dockermanage.repository.UserInfoRepository;
import com.ccut.whiteshark.dockermanage.service.IndexInfoService;
import com.ccut.whiteshark.dockermanage.service.impl.HostInfoServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author WeiPeng
 * @Date 2021/4/6 17:04
 * @Version 1.0
 */
@Service
public class IndexInfoServiceImpl implements IndexInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    UserHostRepository userHostRepository;

    @Override
    public JSONObject getInfo(List<UserHost> userHosts){
        HostInfoServiceImpl service = new HostInfoServiceImpl();
        JSONArray result = service.getHostInfo(userHosts);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalHost",userHosts.size());
        jsonObject.put("activeHost",result.length());
        jsonObject.put("deadHost",userHosts.size()-result.length());
        jsonObject.put("hostList",result);
        return jsonObject;
    }

}
