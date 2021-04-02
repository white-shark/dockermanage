package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.api.Stats;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * @Author WeiPeng
 * @Date 2021/4/2 16:54
 * @Version 1.0
 */
@Service
public class StatsInfoService {
    public JSONArray getStats(String ip, String port, String[] id){
        JSONArray res = new JSONArray();
        JSONObject result = new JSONObject();
        Stats stats = new Stats();
        for (String s : id) {
            JSONObject jsonObject = new JSONObject(stats.getStats(ip, port, s));
            JSONObject jsonObject1 = jsonObject.getJSONObject("memory_stats");
            DecimalFormat df = new DecimalFormat("0.00");
            result.put("memUsage", df.format(jsonObject1.getInt("usage") / jsonObject1.getInt("limit")));
            JSONObject jsonObject2 = jsonObject.getJSONObject("networks");
            JSONObject jsonObject3 = jsonObject2.getJSONObject("eth0");
            result.put("rx_bytes", jsonObject3.getInt("rx_bytes"));
            result.put("tx_bytes", jsonObject3.getInt("tx_bytes"));
            result.put("rx_packets", jsonObject3.getInt("rx_packets"));
            result.put("tx_packets", jsonObject3.getInt("tx_packets"));
            res.put(result);
        }
        return res;
    }
}
