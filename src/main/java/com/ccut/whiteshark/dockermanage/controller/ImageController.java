package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.repository.UserHostRepository;
import com.ccut.whiteshark.dockermanage.service.ImageService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ImageController {

    @Autowired
    UserHostRepository userHostRepository;


    @PostMapping(value = "/image/getList")
    public List<Object> getImageList(HttpSession session){
        List<UserHost> list = userHostRepository.findAllByUserName(String.valueOf(session.getAttribute("userName")));
        ImageService service = new ImageService();
        return service.getImageList(list).toList();
    }

    @PostMapping(value = "/image/delete")
    public String deleteImage(@RequestParam String id,@RequestParam String ip){
        String ids = id.split(":")[1];
        System.out.println(ids + ":" +ip);
        return "success";
    }
}
