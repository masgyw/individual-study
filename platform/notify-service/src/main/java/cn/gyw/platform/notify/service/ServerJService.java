package cn.gyw.platform.notify.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @desc Server酱通知
 * @createdTime 2022/2/1 13:44
 */
@Service("serverJService")
public class ServerJService implements NotifyService {

    private static final Logger log = LoggerFactory.getLogger(ServerJService.class);

    @Value("${notify.service.serverJ.url}")
    private String notifyServerJUrl;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public boolean sendNotify(String title, String content) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 提交参数
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("text", title);
        paramMap.add("desp", content);
        // 请求
        HttpEntity<MultiValueMap<String, String>> postEntity = new HttpEntity<>(paramMap, httpHeaders);
        String result = restTemplate.postForObject(notifyServerJUrl, postEntity, String.class);
        log.info("Server酱服务器推送结果：body={}", result);
        if (StringUtils.isNotEmpty(result)) {
            return true;
        }
        return false;
    }
}
