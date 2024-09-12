package org.lsh.alg.sort;

import org.lsh.alg.util.AlgUtils;

import java.util.Arrays;

public class C06_HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 6, 3, 4, 5, 2, 6, 9, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        AlgUtils.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            AlgUtils.swap(arr, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        /*
         * 这里两个方面，一是确实比父节点大，二是自己不可能比自己大
         */
        while (arr[index] > arr[(index - 1) / 2]) {
            AlgUtils.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            /*
             * 选出两个孩子之间谁大
             * 大于有两个方面一是左孩子确实比右孩子大，二是只有左孩子
             * 一是确保没有越界，并且右孩子大于左孩子，两个条件缺少一个都是左孩子
             */
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 大的和父节点比较，哪个大把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            AlgUtils.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
}
