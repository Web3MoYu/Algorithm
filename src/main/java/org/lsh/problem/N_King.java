package org.lsh.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_King {


    public static void main(String[] args) {
        List<List<String>> ans = new ArrayList<>();
        System.out.println(num(4, ans));
    }

    public static int num(int n, List<List<String>> ans) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n, ans);
    }


    // i代表哪一行
    public static int process(int i, int[] record, int n, List<List<String>> ans) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            StringBuilder s = null;
            for (int t : record) {
                s = new StringBuilder();
                int tt = n - t - 1;
                while (t > 0) {
                    s.append(".");
                    t--;
                }
                s.append("Q");
                while (tt > 0) {
                    s.append(".");
                    tt--;
                }
                list.add(s.toString());
            }
            ans.add(list);
            return 1; // 潜台词：来到i行默认0->i-1都是正确的摆法
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            // 当前i行，放到j列会不会出现共列或共斜线
            if (isValid(record, i, j)) {
                record[i] = j;
                // 会累积计算后面的共有多少种摆法
                res += process(i + 1, record, n, ans);
            }
        }
        System.out.println(Arrays.toString(record));
        return res;
    }

    // 只用检查是不是跟之前的皇后共列和共斜线
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            // j只会有n-1个值，所以比较当前列之前出现过每
            // record[k] - j 是列的差值
            // i - k 是行的差值
            // 二者的绝对值相等代表共线
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

}
