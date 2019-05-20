package com.beng.recursion;

/**
 * @desc 使用递归方式获得数组中数字的和
 * @annotation 一定要注意边界问题
 * @author apple
 */
public class SumArray {
    /**
     * 使用 index 来记录递归到数组中的那个元素，java 中的数组不像 python 中的列表一样，使用之后可以直接 pop 删除
     * 
     * @param arr
     * @param index
     * @return
     */
    public static int sum(int[] arr, int index) {
        // 一下三个判断条件在递归中也被称为 基线条件
        if (arr == null)
            return 0;
        if (arr.length == 0)
            return 0;
        if (index > arr.length - 1) // 注意边界问题
            return 0;
        return arr[index] + sum(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
        System.out.println(sum(arr, 0));
    }
}
