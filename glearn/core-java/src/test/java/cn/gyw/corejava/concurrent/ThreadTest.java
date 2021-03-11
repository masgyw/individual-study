package cn.gyw.corejava.concurrent;

import org.junit.Test;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 线程相关测试
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();

        // threadTest.joinTest();
        threadTest.interruptTest();

        System.out.println("main run over");
    }

    /**
     * 中断测试
     */
    public void interruptTest() {
        BlockingQueue<BigInteger> bigIntegers = new LinkedBlockingQueue<>(10);
        PrimeProducer t2 = new PrimeProducer(bigIntegers);

        t2.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt();
    }

    /**
     * join 方法
     */
    public void joinTest() {
        Thread t1 = new Thread(() -> {
            System.out.println("t1");
        });

        Thread t2 = new Thread(()-> {
            System.out.println("t2 start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
        });

        t1.start();
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class PrimeProducer extends Thread {

        private volatile boolean cancelled = false;

        private final BlockingQueue<BigInteger> queue;

        PrimeProducer(BlockingQueue<BigInteger> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                /* 方法一，可能造成无法响应中断
                BigInteger p = BigInteger.ONE;
                while (!cancelled) {

                    // 线程不安全，若在此阻塞，线程将不会收到取消操作
                    queue.put(p = p.nextProbablePrime());
                }
                */

                // 方法二，
                BigInteger p = BigInteger.ONE;
                while (!Thread.currentThread().isInterrupted()) {
                    // 线程不安全，若在此阻塞，线程将不会收到取消操作
                    queue.put(p = p.nextProbablePrime());
                }


            } catch (InterruptedException e) {
                // 中断
                System.out.println("中断异常，是否中断：" + Thread.currentThread().isInterrupted());

            }
        }

        public void cancel() {
            cancelled = true;
        }
    }

    void consumePrimes() {
        BlockingQueue<BigInteger> bigIntegers = new LinkedBlockingQueue<>(10);
        PrimeProducer primeProducer = new PrimeProducer(bigIntegers);
        primeProducer.start();

        boolean needMorePrims = true;
        try {
            while (needMorePrims) {
                bigIntegers.take();
            }
        } catch (InterruptedException e) {
            // do nothing
        } finally {
            primeProducer.cancel();
        }
    }

}
