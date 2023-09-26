package cn.gyw.glearn.algorithm.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RemoveElementsTest {

    @Test
    public void solution1() {
        int[] data = new int[] {0,1,0,3,12};
        System.out.println(">>" + Arrays.toString(data));

        int result = new RemoveElements().solution1(data, 0);
        Assertions.assertEquals(3, result);

        result = new RemoveElements().solution1(data, 1);
        Assertions.assertEquals(4, result);
    }
}