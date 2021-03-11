package cn.gyw.community.security.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.gyw.community.security.domain.CustomData;

@Component
public class SystemDataCache {
	
    private Map<Integer, CustomData> map = new HashMap<>();

    public SystemDataCache() {
        for (int i = 0; i < 5; i++) {
            map.put(i, new CustomData(i ,"Default system data ： " + i));
        }
    }

    public Map<Integer, CustomData> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CustomData> map) {
        this.map = map;
    }
}
