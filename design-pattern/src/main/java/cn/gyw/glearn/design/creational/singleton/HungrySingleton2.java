package cn.gyw.glearn.design.creational.singleton;

public class HungrySingleton2 {

    private static final HungrySingleton2 INSTANCE = new HungrySingleton2();

    public static HungrySingleton2 getInstance() {
        return INSTANCE;
    }

    private HungrySingleton2() {}
}
