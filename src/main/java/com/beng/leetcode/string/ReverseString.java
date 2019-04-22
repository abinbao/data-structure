package com.beng.leetcode.string;

import java.util.Arrays;

/**
 * 字符串翻转
 * 
 * @author apple
 */
public class ReverseString {
    /**
     * leetcode 字符串输出真坑
     * 
     * @param s
     */
    public static void reverseString(char[] s) {
        if (s == null || s.length == 1)
            return;
        int p = 0;
        int q = s.length - 1;
        while (p < q) {
            char tmp = s[p];
            s[p] = s[q];
            s[q] = tmp;
            p++;
            q--;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        reverseString(new char[] { 'h', 'e', 'l', 'l', 'o' });
    }
}
