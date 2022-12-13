package cn.gyw.platform.common.util;

public class StringUtil {

    /**
     * 下划线转驼峰
     * user_name  ---->  userName
     * house.user_name  ---->  userName
     * userName   --->  userName
     *
     * @param underlineName 带有下划线的名字
     * @return 驼峰字符串
     */
    public static String underlineToHump(String underlineName) {
        //截取下划线分成数组
        char[] charArray = underlineName.toCharArray();
        //判断上次循环的字符是否是"_"
        boolean underlineBefore = false;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0, l = charArray.length; i < l; i++) {
            //判断当前字符是否是"_",如果跳出本次循环
            if (charArray[i] == 95) {
                underlineBefore = true;
            } else if (underlineBefore) {
                //如果为true，代表上次的字符是"_",当前字符需要转成大写
                buffer.append(charArray[i] -= 32);
                underlineBefore = false;
            } else { //不是"_"后的字符就直接追加
                buffer.append(charArray[i]);
            }
        }
        return buffer.toString();
    }

    /**
     * 驼峰转 下划线
     * userName  ---->  user_name
     * user_name  ---->  user_name
     *
     * @param humpName 驼峰命名
     * @return 带下滑线的String
     */
    public static String humpToUnderline(String humpName) {
        //截取下划线分成数组，
        char[] charArray = humpName.toCharArray();
        StringBuffer buffer = new StringBuffer();
        //处理字符串
        for (int i = 0, l = charArray.length; i < l; i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90) {
                buffer.append("_").append(charArray[i] += 32);
            } else {
                buffer.append(charArray[i]);
            }
        }
        return buffer.toString();
    }

    /**
     * 首字母转大写
     *
     * @param target 字符串
     * @return 首字母大写的字符串
     */
    public static String firstLetterToUp(String target) {
        char[] cs = target.toCharArray();
        if (97 <= cs[0] && cs[0] <= 122) {
            cs[0] ^= 32;
        }
        return String.valueOf(cs);
    }

    /**
     * 首字母转小写
     *
     * @param target 字符串
     * @return 首字母小写的字符串
     */
    public static String firstLetterToLower(String target) {
        char[] cs = target.toCharArray();
        if (cs[0] >= 65 && cs[0] <= 90) {
            // ascii 码值计算
            cs[0] += 32;
        }
        return String.valueOf(cs);
    }

    /**
     * 去掉指定后缀
     *
     * @param str    字符串
     * @param suffix 后缀
     * @return 切掉后的字符串，若后缀不是 suffix， 返回原字符串
     */
    public static String removeSuffix(CharSequence str, CharSequence suffix) {
        if (isEmpty(str) || isEmpty(suffix)) {
            return str(str);
        }

        final String str2 = str.toString();
        if (str2.endsWith(suffix.toString())) {
            return str2.substring(0, str2.length() - suffix.length());// 截取前半段
        }
        return str2;
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static String str(CharSequence cs) {
        return null == cs ? null : cs.toString();
    }

    private StringUtil() {
    }
}
