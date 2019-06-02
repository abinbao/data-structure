package com.beng.leetcode.simple;

/**
 * {@link https://leetcode.com/problems/binary-search/}
 * 
 * @author apple
 */
public class BinarySearch {

    /**
     * 二分查找
     * 
     * @annotation 注意边界条件
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null)
            return -1;
        int high = nums.length - 1;
        int low = 0;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                high--;
            } else {
                low++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 0, 5, 8, 13, 15, 38 }, 8));
    }
}
