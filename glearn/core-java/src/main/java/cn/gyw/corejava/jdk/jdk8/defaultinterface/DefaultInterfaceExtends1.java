package cn.gyw.corejava.jdk.jdk8.defaultinterface;

/**
 * 默认接口的默认方法冲突问题
 *
 *
 */
public interface DefaultInterfaceExtends1 extends InterfaceDefaultMethod {

    @Override
    default int add(int x, int y) {
        System.out.println("Sub DefaultInterfaceExtends1");
        return x + y + 1;
    }
}
