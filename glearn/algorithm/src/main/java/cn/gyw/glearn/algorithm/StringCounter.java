package cn.gyw.glearn.algorithm;

/**
 * 找出某个字符串中出现次数最多的字符
 */
public class StringCounter {

    public static void main(String[] args) {
    	// 大写字母存在问题
        String target = "wuoernzoxuhqernglaut";
        int[] data = new int[26];

        char[] chars = target.toCharArray();
        int maxIndex = 0;
        char maxChar = 'a';
        int loc = 0;
        for (int i = 0, len = chars.length ; i < len ; i ++) {
            loc = chars[i] - 'a';
            System.out.println(i + ">>" + loc);
            data[loc] = data[loc] + 1;
            if (data[maxIndex] < data[loc]) {
                maxIndex = loc;
                maxChar = chars[i];
            }
        }

        System.out.println("次数最多：" + maxChar);
    }
}
