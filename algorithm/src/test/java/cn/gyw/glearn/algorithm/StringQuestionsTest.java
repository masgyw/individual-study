package cn.gyw.glearn.algorithm;

import cn.gyw.glearn.algorithm.util.DataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 字符串相关问题测试
 */
public class StringQuestionsTest {

    private StringQuestions stringQuestions;

    /**
     * 字符最大频率问题
     */
    @Test
    public void mostChar() {
        String target = DataGenerator.generateString(32);
        char c = stringQuestions.findMostChar(target);
        System.out.println("<<" + String.valueOf(c));
    }

    /**
     * 最大不重复子串
     */
    @Test
    public void findLongestUniqueSubString() {
        String target = "abcabcbb";
        Assertions.assertEquals("abc", stringQuestions.findLongestUniqueSubString(target));
        target = "bbbb";
        Assertions.assertEquals("b", stringQuestions.findLongestUniqueSubString(target));
        target = "btwwt";
        Assertions.assertEquals("btw", stringQuestions.findLongestUniqueSubString(target));
    }

    @BeforeEach
    public void init() {
        stringQuestions = new StringQuestions();
    }
}
