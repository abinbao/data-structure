package com.beng.leetcode.sort;

import java.util.Arrays;

/**
 * @desc 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * @author apple
 */
public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("abb", "bb"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
