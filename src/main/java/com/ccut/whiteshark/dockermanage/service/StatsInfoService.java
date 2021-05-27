package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.api.Stats;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DecimalFormat;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/3 11:47 下午
 */
public interface StatsInfoService {

    public JSONArray getStats(String ip, String port, String[] id);

}
