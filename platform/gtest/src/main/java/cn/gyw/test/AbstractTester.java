package cn.gyw.test;

import cn.gyw.test.junit.annotations.GJunit;
import cn.gyw.test.junit.intercepters.GTimeIntercepter;
import cn.gyw.test.junit.runners.GInterceperRunner;
import org.junit.runner.RunWith;

@GJunit(values = {
        GTimeIntercepter.class
})
@RunWith(value = GInterceperRunner.class)
public class AbstractTester {

}
