package org.lsh.alg.util;

public class AlgUtils {

    /**
     * 交换二者，前提两个数的内存不是一块，否则为0
     */
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

    }
}
