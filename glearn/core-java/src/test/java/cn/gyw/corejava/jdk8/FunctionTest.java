package cn.gyw.corejava.jdk8;

import cn.gyw.corejava.AbstractTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author
 * @desc
 * @createdTime 2022/8/16
 */
public class FunctionTest extends AbstractTest {

    /**
     * 策略模式
     */
    @Test
    public void strategyPattern() {
        Function<Double, Double> tenPercentDiscount = x -> x * 0.9;

        Stream.<Double>of(5.4, 6.27, 3.29).map(tenPercentDiscount)
                .forEach(System.out::println);
    }

    @Test
    public void t() {
        Map<String, Function<String, String>> indexMap = new HashMap<>();
        indexMap.put("idNoDigest", new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "1";
            }
        });
        indexMap.put("mobile", new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "2";
            }
        });

        String ret = indexMap.get("idNoDigest").apply("11234");
        System.out.println("ret = " + ret);
    }
}
