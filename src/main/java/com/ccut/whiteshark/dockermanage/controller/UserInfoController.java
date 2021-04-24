package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import com.ccut.whiteshark.dockermanage.repository.UserHostRepository;
import com.ccut.whiteshark.dockermanage.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author WeiPeng
 * @Date 2021/4/6 9:26
 * @Version 1.0
 */
@RestController
public class UserInfoController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    UserHostRepository userHostRepository;

    private final static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @PostMapping(value = "/user/getDockerHub")
    public UserInfo getDockerHub(HttpSession session){
        return userInfoRepository.findByUserName((String) session.getAttribute("userName"));
    }
    @PostMapping(value = "/user/setDockerHub")
    public String setDockerHub(@RequestParam String dockerHub,@RequestParam String privateRegistry,
                               @RequestParam String registryUser,@RequestParam String registryPass,
                               @RequestParam String registryMail,HttpSession session){
        try {
            UserInfo userInfo = userInfoRepository.findByUserName((String) session.getAttribute("userName"));
            userInfo.setDockerHub(dockerHub);
            userInfo.setPrivateRegistry(privateRegistry);
            userInfo.setRegistryUser(registryUser);
            userInfo.setRegistryPass(registryPass);
            userInfo.setRegistryMail(registryMail);
            userInfoRepository.save(userInfo);
            return "success";
        }catch (Exception e){
            return "error";
        }

    }
    @PostMapping(value = "/user/increaseHost")
    public String increaseHost(HttpSession session, @RequestParam String host,@RequestParam String ipAddress,@RequestParam String port){
        UserHost userHost = new UserHost();
        userHost.setHost(ipAddress);
        userHost.setHostName(host);
        userHost.setUserName((String) session.getAttribute("userName"));
        userHost.setPort(port);
        try {
            userHostRepository.save(userHost);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    @PostMapping(value = "/user/getHostList")
    public List<UserHost> getHostList(HttpSession session){
        List<UserHost> list = new ArrayList<>();
        list = userHostRepository.findAllByUserName((String) session.getAttribute("userName"));
        return list;
    }

    @PostMapping(value = "/user/delete/host")
    public String delHost(@RequestParam Integer id){
        System.out.println("id:"+ id);
        try {
            userHostRepository.deleteById(id);
            return "success";
        }catch (Exception e){
            logger.warn("删除失败");
            return "error";
        }
    }
}
