package cn.gyw.community.system;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.gson.Gson;

public class JsonTest {

    @Test
    public void testJsonSet() {
        Set<String> resources = new HashSet<>();
        resources.add("0099");
        resources.add("0088");
        Gson gson = new Gson();
        System.out.println(gson.toJson(resources));
    }

    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));
    }
}
