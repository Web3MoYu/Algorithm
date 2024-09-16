package org.lsh.alg.greedyAlg;

import java.util.Arrays;

// 最低字典序
public class C02_lowestLexicography {

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder res = new StringBuilder();
        for (String cur : strs){
            res.append(cur);
        }
        return res.toString();
    }
}
