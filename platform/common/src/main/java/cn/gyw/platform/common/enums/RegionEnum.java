package cn.gyw.platform.common.enums;

import cn.gyw.platform.common.model.ProvinceCity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 地域工具类
 *
 * @date 2022/1/25 17:11
 */
public enum RegionEnum {
    INSTANCE;

    private static final Logger log = LoggerFactory.getLogger(RegionEnum.class);
    /**
     * 中国区域缓存
     */
    private static Map<String, ProvinceCity> REGION_CACHE;

    /**
     * 获取城市列表
     * @param province 省
     * @return 省对象
     */
    public static ProvinceCity get(String province) {
        return REGION_CACHE.get(province);
    }

    private void loadJsonFile() {
        REGION_CACHE = new ConcurrentHashMap<>();
        try (InputStream in = RegionEnum.class.getClassLoader().getResourceAsStream("locList.json")) {
            ObjectReader reader = new ObjectMapper().reader();
            JsonNode jsonNode = reader.readTree(in);
            for (Iterator<JsonNode> iter = jsonNode.get("provinces").elements(); iter.hasNext(); ) {
                JsonNode provNode = iter.next();
                ProvinceCity provinceCity = buildProvinceCity(provNode);
                provinceCity.setChildren(new ArrayList<>());
                for (Iterator<JsonNode> it = provNode.get("city").elements(); it.hasNext(); ) {
                    provinceCity.getChildren().add(buildProvinceCity(it.next()));
                }
                REGION_CACHE.put(provinceCity.getName(), provinceCity);
            }
        } catch (IOException e) {
            log.error("", e);
        }
    }

    private ProvinceCity buildProvinceCity(JsonNode node) {
        ProvinceCity provinceCity = new ProvinceCity();
        provinceCity.setName(node.get("name").asText());
        provinceCity.setCode(node.get("code").asText());
        return provinceCity;
    }

    RegionEnum() {
        loadJsonFile();
    }
}
