package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.repository.UserHostRepository;
import com.ccut.whiteshark.dockermanage.service.IndexInfoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author WeiPeng
 * @Date 2021/4/6 17:03
 * @Version 1.0
 */
@RestController
public class IndexInfoController {

    @Autowired
    UserHostRepository userHostRepository;

    @PostMapping(value = "/getIndexInfo")
    public String getInfo(HttpSession session){
        List<UserHost> list = userHostRepository.findAllByUserName((String) session.getAttribute("userName"));
        IndexInfoService service = new IndexInfoService();
        JSONObject jsonObject = service.getInfo(list);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }
}
