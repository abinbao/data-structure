package com.beng.leetcode.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link https://leetcode.com/problems/contains-duplicate/}
 * 
 * @author apple
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        if (null == nums)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return true;
            else
                set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] { 1, 411, 2, 411 }));
    }
}
