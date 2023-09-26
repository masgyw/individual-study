package cn.gyw.glearn.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.gyw.glearn.algorithm.stack.StackWithReverse;

import java.util.Stack;

/**
 * 仅用递归函数完成栈反转
 */
public class StackWithReverseTest {

    @Test
    public void reverseStack() {
        System.out.println("1>>" + dataStack);
        StackWithReverse.reverse(dataStack);
        System.out.println("2>>" + dataStack);
    }

    /**
     * 数据准备
     */
    @BeforeEach
    public void setUp() {
        dataStack = new Stack<>();
        dataStack.push(1);
        dataStack.push(2);
        dataStack.push(3);
        dataStack.push(4);
        dataStack.push(5);
    }

    private Stack<Integer> dataStack;

}
