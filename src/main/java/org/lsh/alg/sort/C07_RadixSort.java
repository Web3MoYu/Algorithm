package org.lsh.alg.sort;

import java.util.Arrays;

public class C07_RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 6, 3, 4, 5, 2, 6, 9, 0};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    private static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(max, j);
        }
        int res = 0;
        while (max != 0) {
            max /= 10;
            ++res;
        }
        return res;
    }

    private static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;// 代表是几进制
        int i = 0, j = 0;
        int[] bucket = new int[R - L + 1];

        for (int d = 1; d <= digit; d++) {
            // count[i]表示当前位(d位)小于等于i的个数
            int[] count = new int[radix]; //[0...9]
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d); // 获得第d位
                count[j]++;
            }

            // 前缀和
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // 从右往左遍历，确保桶的先进先出
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    private static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
}
