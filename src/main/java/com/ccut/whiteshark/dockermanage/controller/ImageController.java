package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import com.ccut.whiteshark.dockermanage.repository.UserHostRepository;
import com.ccut.whiteshark.dockermanage.repository.UserInfoRepository;
import com.ccut.whiteshark.dockermanage.service.ImageService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/11 12:34 上午
 */
@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    UserHostRepository userHostRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    ImageService service;


    @PostMapping(value = "/getList")
    public List<Object> getImageList(HttpSession session){
        List<UserHost> list = userHostRepository.findAllByUserName(String.valueOf(session.getAttribute("userName")));
        return service.getImageList(list).toList();
    }

    @PostMapping(value = "/delete")
    public String deleteImage(@RequestParam String id,@RequestParam String ip,HttpSession session){
        UserHost userHost = userHostRepository.findByUserNameAndHost(String.valueOf(session.getAttribute("userName")),ip);
        String ids = id.split(":")[1];
        return service.deleteImage(ip,userHost.getPort(),ids);
    }

    @PostMapping(value = "/search")
    public String searchImage(String search,HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUserName(String.valueOf(session.getAttribute("userName")));
        List<UserHost> list = userHostRepository.findAllByUserName(userInfo.getUserName());
        JSONArray array =  service.searchImage(list.get(0).getHost(),list.get(0).getPort(),userInfo,search);
        return array.toString();
    }

    @PostMapping(value = "/pull")
    public String pullImage(String imageName,String ip,HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUserName(String.valueOf(session.getAttribute("userName")));
        UserHost userHost = userHostRepository.findByUserNameAndHost(userInfo.getUserName(),ip);
        JSONArray array =  service.searchImage(userHost.getHost(),userHost.getPort(),userInfo,imageName);
        return array.toString();
    }

}
