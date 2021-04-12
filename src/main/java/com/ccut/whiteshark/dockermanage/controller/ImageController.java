package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.service.ImageService;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/11 12:34 上午
 */
@RestController
public class ImageController {

    @PostMapping(value = "/image/getList")
    public JSONArray getImageList(@RequestParam String ip,@RequestParam String port, HttpSession session){
        ImageService service = new ImageService();
        return service.getImageList(ip, port);
    }
}
