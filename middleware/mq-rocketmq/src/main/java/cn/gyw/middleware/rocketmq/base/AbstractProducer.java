package cn.gyw.middleware.rocketmq.base;

import cn.gyw.middleware.rocketmq.common.AppProperties;
import cn.gyw.middleware.rocketmq.model.MsgConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象消息生产者
 *
 * @date 2022/1/30 9:25
 */
public abstract class AbstractProducer<T> implements MsgSender {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    protected MQProducer mqProducer;

    public AbstractProducer() {
        buildProducer();
    }

    /**
     * 一个应用创建一个Producer，由应用来维护此对象，可以设置为全局对象或者单例
     */
    protected void buildProducer() {
        /*
         * 注意：ProducerGroupName需要由应用来保证唯一
         * ProducerGroup这个概念发送普通的消息时，作用不大。
         * 但是发送分布式事务消息时，比较关键，
         * 因为服务器会回查这个Group下的任意一个Producer
         */
        MsgConfig msgConfig = getMsgConfig();
        DefaultMQProducer producer = new DefaultMQProducer(msgConfig.getGroup());
        producer.setNamesrvAddr(AppProperties.getNameserverAddr());
        producer.setCompressMsgBodyOverHowmuch(1024 * 1024 * 5);
        producer.setMaxMessageSize(1024 * 1024 * 20);

        try {
            /*
             * Producer对象在使用之前必须要调用start初始化，初始化一次即可<br>
             * 注意：切记不可以在每次发送消息时，都调用start方法
             */
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        mqProducer = producer;
    }

    /**
     * 应用退出时，要调用shutdown来清理资源，关闭网络连接，从MetaQ服务器上注销自己
     * 注意：我们建议应用在JBOSS、Tomcat等容器的退出钩子里调用shutdown方法
     */
    public void stop() {
        mqProducer.shutdown();
    }

    protected byte[] getMsgContent(T bean) {
        return JSON.toJSONString(bean).getBytes();
    }

    protected abstract MsgConfig getMsgConfig();
}
