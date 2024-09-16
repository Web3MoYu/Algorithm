package org.lsh.alg.dp;


public class C02_PrintAllSubstring {

    public static void main(String[] args) {
        char[] chs = "abc".toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs).replace(" ", ""));
            return;
        }
        // 要当前字符
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = ' '; // 置为空，下一个就是不要当前位置
        process(chs, i + 1);
        chs[i] = tmp; // 重新赋值
    }
}
