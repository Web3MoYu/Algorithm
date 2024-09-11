package org.lsh.alg.find;

public class BinaryFind {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binaryFind(arr, 11));
    }

    public static int binaryFind(int[] arr, int num) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] == num) {
                return mid;
            }
            if (arr[mid] > num) {
                right = mid - 1;
            }
            if (arr[mid] < num) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
