package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.api.HostInfo;
import com.ccut.whiteshark.dockermanage.entity.HostEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DecimalFormat;

/**
 * @Author WeiPeng
 * @Date 2021/4/2 16:47
 * @Version 1.0
 */
public class HostInfoService {
    public JSONArray getHostInfo(JSONArray array){
        HostInfo hostInfo = new HostInfo();
        JSONObject hosts;
        JSONArray result = new JSONArray();
        for (int i = 0;i < array.length();i++){
            hosts = array.getJSONObject(i);
            String res = hostInfo.getHostInfo(hosts.getString("ip"),hosts.getString("port"));
            JSONObject jsonObject = new JSONObject(res);
            HostEntity entity = new HostEntity();
            entity.setArchitecture(jsonObject.getString("Architecture"));
            entity.setContainersRunning(jsonObject.getInt("ContainersRunning"));
            entity.setId(jsonObject.getString("ID"));
            DecimalFormat df = new DecimalFormat("0.00");
            entity.setMemTotal(df.format(jsonObject.getInt("MemTotal")/1024));
            entity.setNCpu(jsonObject.getInt("NCPU"));
            entity.setSystemTime(jsonObject.getString("SystemTime").split("\\.")[0]);
            entity.setOperatingSystem(jsonObject.getString("OperatingSystem"));
            entity.setServerVersion(jsonObject.getString("ServerVersion"));
            result.put(entity);
        }
        return result;
    }
}
