package cn.gyw.spring.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * spring BeanUtils Test
 * @date 2022/10/13
 */
public class BeanUtilsTest {

    @Test
    public void testGetProperty() throws InvocationTargetException, IllegalAccessException {
        PropertyDescriptor ps = BeanUtils.getPropertyDescriptor(Target.class, "name");
        Method readMethod = ps.getReadMethod();
        List<Target> dataList =  mockData();
        for (Target target : dataList) {
            Object value = readMethod.invoke(target);
            System.out.println("value = " + value);
        }
    }

    private List<Target> mockData() {
        List<Target> dataList = new ArrayList<>();
        dataList.add(new Target("AAAA"));
        dataList.add(new Target("BBB"));
        dataList.add(new Target("CCCC"));
        dataList.add(new Target("DDDD"));
        return dataList;
    }



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Target {
        private String name;
    }
}
