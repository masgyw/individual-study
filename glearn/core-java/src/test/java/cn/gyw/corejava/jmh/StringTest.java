package cn.gyw.corejava.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @date 2022/8/24
 */
// Benchmark时所使用的模式
@BenchmarkMode({Mode.AverageTime})
// 输出结果的时间单位
@OutputTimeUnit(TimeUnit.NANOSECONDS)
// 程序预热所需要的一些参数，可以用在类或者方法上
@Warmup(time = 1, iterations = 5)
@Measurement(time = 1, iterations = 5)
@Fork(1)
// 指定一个对象的作用范围，实例化和共享操作
@State(value = Scope.Benchmark)
public class StringTest {
    @Param({"10", "100", "1000"})
    private int size;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringTest.class.getSimpleName())
                .result("StringTest_result.json")
                .resultFormat(ResultFormatType.JSON).build();
        new Runner(opt).run();
    }

    @Benchmark
    public String testAdd() {
        String a = "";
        for (int i = 0; i < size; i++) {
            a = a + i;
        }
        return a;
    }

    @Benchmark
    public String testConcat() {
        String a = "";
        for (int i = 0; i < size; i++) {
            a = a.concat("" + i);
        }
        return a;
    }

    @Benchmark
    public String testBuilder() {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < size; i++) {
            a.append(i);
        }
        return a.toString();
    }

    @Benchmark
    public String testBuffer() {
        StringBuffer a = new StringBuffer();
        for (int i = 0; i < size; i++) {
            a.append(i);
        }
        return a.toString();
    }
}
