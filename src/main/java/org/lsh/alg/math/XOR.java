package org.lsh.alg.math;

/**
 * 异或运算，相同为0，不同为1相当于无进位相加
 * 性质：
 * 0^N = N, N^N = 0
 * 满足交换律和结合律
 * 所以交换两个数的值可以写成 a = a^b b = a^b a = a^b
 */
public class XOR {

    /**
     * 有一堆数，有两个是奇数次，其他是偶数次，找到奇数次的数
     * @param arr
     */
    public static void xor(int[] arr) {
        int xor = 0, xor1 = 0;
        for (int num : arr) {
            xor ^= num;
        }
        /**
         * 101101
         * 010011
         */
        // 获得最右侧的1
        int rightOne = xor & (~xor + 1);
        for (int num : arr) {
            // 找到a或b中的一个
            if ((num & rightOne) == 0) {
                xor1 ^= num;
            }
        }

        System.out.println(xor + " " + (xor ^ xor1));
    }
}
