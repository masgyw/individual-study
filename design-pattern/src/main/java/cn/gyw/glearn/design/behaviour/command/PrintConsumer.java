package cn.gyw.glearn.design.behaviour.command;

import java.util.function.Consumer;

/**
 * @author
 * @desc
 * @createdTime 2022/8/16
 */
public class PrintConsumer implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
