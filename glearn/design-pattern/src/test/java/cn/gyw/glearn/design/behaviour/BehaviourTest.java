package cn.gyw.glearn.design.behaviour;

import cn.gyw.glearn.design.behaviour.chainofresponsibility.*;
import org.junit.Test;

/**
 * 行为型模式测试
 */
public class BehaviourTest {

    /**
     * 责任链模式
     */
    @Test
    public void responsibility() {
        Director director = new Director("主任");
        GeneralManager generalManager = new GeneralManager("总经理对象");
        Manager manager = new Manager("经理");
        director.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        Request[] requests = new Request[5];
        requests[0] = new LeaveRequest("小王1", 3, "回家1");
        requests[1] = new LeaveRequest("小王2", 13, "回家2");
        requests[2] = new LeaveRequest("小王3", 23, "回家3");
        requests[3] = new LeaveRequest("小王4", 33, "回家4");
        requests[4] = new LeaveRequest("小王5", 43, "回家5");

        for (int i = 0 ; i < requests.length ; i ++) {
            director.handle(requests[i]);
        }
    }

    /**
     * 命令模式
     */
    @Test
    public void commandTest() {
    }
}
