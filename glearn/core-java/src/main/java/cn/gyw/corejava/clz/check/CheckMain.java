package cn.gyw.corejava.clz.check;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * @date 2022/11/16
 */
public class CheckMain {

    public static void main(String[] args) throws Exception {
        CheckMain checkMain = new CheckMain();
        checkMain.run();
    }

    private void run() throws Exception {
        Field[] fields = CheckBean.class.getDeclaredFields();
        Stream.of(fields).forEach(System.out::println);

        for (Field field : fields) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), CheckBean.class);
            System.out.println("pd = " + pd);
        }
    }

}
