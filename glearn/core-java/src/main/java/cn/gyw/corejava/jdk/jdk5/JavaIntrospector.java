package cn.gyw.corejava.jdk.jdk5;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guanyw on 2017/9/12.
 * java 内省机制
 */
public class JavaIntrospector {

    public static void main(String[] args) {
    Map<String,String> params = new HashMap<>();
        params.put("name", "gyw");
        params.put("aPoint", "上海");
        params.put("zPoint", "南京");
        Bean bean = new Bean();
        try {
            //1.获取JavaBean的描述信息
            BeanInfo info = Introspector.getBeanInfo(Bean.class);
            //2.获取JavaBean的属性信息
            PropertyDescriptor[] prop = info.getPropertyDescriptors();
            //3.遍历属性信息
            for(PropertyDescriptor pd : prop) {
                String value = params.get(pd.getName());
                pd.getWriteMethod().invoke(bean,value);
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(bean);
    }
}
