package org.lsh.alg.array.sort;

import java.util.Arrays;

public class C04_MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{14, 44, 22, 61, 42, -3, -30, 12, 6, 32, 98, 21, 23, 231, 5, 76, 33, 87, 43};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] res = new int[R - L + 1];
        int i = 0, p1 = L, p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            res[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            res[i++] = arr[p1++];
        }
        while (p2 <= R) {
            res[i++] = arr[p2++];
        }
        for (i = 0; i < res.length; i++) {
            arr[L + i] = res[i];
        }
    }


}

class SmallSum {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 7, 5, 4, 6};
        System.out.println(process(arr, 0, arr.length - 1));
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        int[] res = new int[R - L + 1];
        int sum = 0;
        int i = 0, p1 = L, p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            // 小和
            sum += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            res[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];

            // 逆序对
//            sum += arr[p1] > arr[p2] ? (M - p1 + 1) : 0;
//            if (arr[p1] == arr[p2]){
//                res[i++] = arr[p1++];;
//            }else{
//                res[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
//            }
        }
        while (p1 <= M) {
            res[i++] = arr[p1++];
        }
        while (p2 <= R) {
            res[i++] = arr[p2++];
        }
        for (i = 0; i < res.length; i++) {
            arr[L + i] = res[i];
        }
        return sum;
    }
}