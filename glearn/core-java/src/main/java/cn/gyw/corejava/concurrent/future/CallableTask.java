package cn.gyw.corejava.concurrent.future;

import java.util.concurrent.Callable;

/**
 * 进行异步计算结果
 * 检测异步计算是否完成，以及获取计算后的结果
 * @createdTime 2022/4/23
 */
public class CallableTask implements Callable<Integer> {

    private Integer i;

    public CallableTask(Integer i) {
        super();
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        long start = System.currentTimeMillis();

        if (i == 3) {
            Thread.sleep(3000);
        } else if (i == 5) {
            Thread.sleep(5000);
        } else {
            Thread.sleep(1000);
        }

        System.out.println("task 线程" + Thread.currentThread().getName() + ", 任务=" + i
                + "执行完成！耗时：" + (System.currentTimeMillis() - start));
        return i;
    }
}
