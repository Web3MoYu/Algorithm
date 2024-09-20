package org.lsh.alg.string;

public class C01_KMP {

    public static void main(String[] args) {
        System.out.println(getIndexOf("sadbutsad", "sad"));
    }

    public static int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s1.length() < s2.length()) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < s1.length() && i2 < s2.length()) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (i2 == 0) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == s2.length() ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; //next数组的位置
        int cn = 0;
        while (i < next.length) {
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
