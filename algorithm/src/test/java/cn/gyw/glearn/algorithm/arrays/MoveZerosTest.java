package cn.gyw.glearn.algorithm.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.gyw.glearn.algorithm.arrays.MoveZeros;

import java.util.Arrays;

public class MoveZerosTest {

    private MoveZeros moveZeros;
    private int[] data;

    @Test
    public void solution1() {
        moveZeros.solution1(data);
    }

    @Test
    public void solution2() {
        moveZeros.solution2(data);
    }

    @Test
    public void solution3() {
        moveZeros.solution3(data);
    }

    @BeforeEach
    public void before() {
        moveZeros = new MoveZeros();
        data = new int[] {0,1,0,3,12};
        System.out.println(">>" + Arrays.toString(data));
    }

    @AfterEach
    public void after() {
        System.out.println("<<" + Arrays.toString(data));
    }
}