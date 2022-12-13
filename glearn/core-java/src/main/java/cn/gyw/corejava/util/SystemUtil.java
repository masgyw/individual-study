package cn.gyw.corejava.util;

/**
 * 系统工具类
 */
public class SystemUtil {

    /**
     * 打印指定空格数
     * @param num
     * @return
     */
    public static String printBlack(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * 打印分割线
     */
    public static void printCutOffRule() {
        System.out.println("----------------分割线-------------------");
    }

    /**
     * 打印系统参数
     */
    public static void printProperties() {
		System.getProperties().entrySet().stream().forEach(entry -> {
			System.out.println(entry.getKey() + " >> " + entry.getValue());
		});
	}

    /**
     * 获取CPU 数
     * @return
     */
    public static int getCpuCnt() {
        return Runtime.getRuntime().availableProcessors();
    }

    private SystemUtil() {}
}
