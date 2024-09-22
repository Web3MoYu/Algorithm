package org.lsh.alg.string;

// 最大回文长度
public class C02_Manacher {

    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length]; // 回文半径数组
        int C = -1; // 中心
        int R = -1; // 回文右边界的再往右一个位置  R-1是有效区
        int max = Integer.MIN_VALUE; // 最大回文半径
        for (int i = 0; i < str.length; i++) { // 对每一个位置都求回文半径
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            //    不超右边界                      不超左边界
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                //   右边的字符              左边的字符
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // 记录最大回文边界
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        // #1#2#1# #1#1#
        // max-1之后就是原本字符串最大回文串的长度
        return max - 1;
    }

    public static void main(String[] args) {
        System.out.println(maxLcpsLength("babad"));
    }
}
