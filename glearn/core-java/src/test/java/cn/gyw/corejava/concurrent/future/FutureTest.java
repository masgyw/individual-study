package cn.gyw.corejava.concurrent.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author
 * @desc CompletableFuture
 * @createdTime 2022/4/23
 */
public class FutureTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        try {
            // 结果集合
            List<Integer> list = new ArrayList<>();
            List<Future<Integer>> futureList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                futureList.add(executor.submit(new CallableTask(i + 1)));
            }

            for (Future<Integer> integerFuture : futureList) {
                // 阻塞获取结果
                Integer i = integerFuture.get();
                list.add(i);
                System.out.println("任务 " + i + "获取完成");
            }
            System.out.println("list = " + list);
            System.out.println("总耗时：" + (System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}