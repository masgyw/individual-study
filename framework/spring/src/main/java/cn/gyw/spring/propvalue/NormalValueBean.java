package cn.gyw.spring.propvalue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @desc 普通的SpringBean
 * @createdTime 2022/4/21 14:43
 */
@Component
public class NormalValueBean {

    /**
     * 无setHost 方法，@Value 依旧可以注入
     */
    @Value("${host}")
    private String host;

    public String getHost() {
        return host;
    }
}
