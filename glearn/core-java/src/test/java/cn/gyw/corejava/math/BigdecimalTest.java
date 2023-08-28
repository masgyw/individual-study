package cn.gyw.corejava.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @date 2023/8/28
 */
public class BigdecimalTest {

    @Test
    public void testRound() {
        BigDecimal bigDecimal = new BigDecimal("-1.125");

        System.out.println(bigDecimal.setScale(2, RoundingMode.DOWN));
    }
}
