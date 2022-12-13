package cn.gyw.corejava;

import cn.gyw.corejava.junit.annotations.JunitCustom;
import cn.gyw.corejava.junit.custom.JunitTimeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JunitCustom(values = {
        JunitTimeInterceptor.class
})
public abstract class AbstractTest {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

}
