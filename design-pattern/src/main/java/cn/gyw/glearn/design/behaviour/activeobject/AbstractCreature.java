package cn.gyw.glearn.design.behaviour.activeobject;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 活动对象模式
 * 实现活动对象模式的类将包含自同步机制，而无需使用“同步”方法
 * <p>
 * 实现具有自己的控制机制线程并仅公开其API而不公开自己的执行，我们可以使用活动对象模式
 *
 * @date 2023/10/24
 */
public abstract class AbstractCreature {

    private static final Logger log = LoggerFactory.getLogger(AbstractCreature.class);

    private BlockingQueue<Runnable> requests;

    @Getter
    private String name;

    private Thread thread;

    public AbstractCreature(String name) {
        this.name = name;
        this.requests = new LinkedBlockingQueue<>();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        requests.take().run();
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                }
            }
        });
        thread.start();
    }

    public void eat() throws InterruptedException {
        requests.put(new Runnable() {
            @Override
            public void run() {
                log.info("{} is eating!", getName());
                log.info("{} has finished eating!", getName());
            }
        });
    }

    public void roam() throws InterruptedException {
        requests.put(() -> {
            log.info("{} has started to roam and the wastelands", getName());
        });
    }

}
