package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import com.ccut.whiteshark.dockermanage.repository.UserHostRepository;
import com.ccut.whiteshark.dockermanage.repository.UserInfoRepository;
import com.ccut.whiteshark.dockermanage.service.ImageService;
import org.json.JSONArray;
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
    public JSONArray getImageList(HttpSession session){
        List<UserHost> list = userHostRepository.findAllByUserName(String.valueOf(session.getAttribute("userName")));
        ImageService service = new ImageService();
        JSONArray array = service.getImageList(list);
        System.out.println(array);
        return array;
    }
}
