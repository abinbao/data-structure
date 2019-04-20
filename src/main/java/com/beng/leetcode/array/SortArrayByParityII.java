package com.beng.leetcode.array;

/*
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * @author apple
 * @desc  
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
你可以返回任何满足上述条件的数组作为答案。
示例：
    输入：[4,2,5,7]
    输出：[4,5,2,7]
    解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
提示：
    2 <= A.length <= 20000
    A.length % 2 == 0
    0 <= A[i] <= 1000
 */
public class SortArrayByParityII {

    /**
     * 空间换时间； 时间复杂度 O(n), 空间复杂度 O(n)
     * 
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length <= 1)
            return A;
        int len = A.length;
        int[] arr = new int[len];

        int odd = 0;
        int even = 1;
        for (int i = 0; i < len; ++i) {
            // 奇数
            if (A[i] % 2 == 0) {
                arr[odd] = A[i];
                odd = odd + 2;
                // 偶数
            } else {
                arr[even] = A[i];
                even = even + 2;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 2, 5, 7 };
        int[] result = sortArrayByParityII(arr);
        for (int item : result) {
            System.out.print(item + " ");
        }
    }
}
