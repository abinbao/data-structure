package com.beng.leetcode.string;

/**
 * leetCode 796. Rotate String
 * 
 * @author apple
 */
public class RotateString {

    // A shift on A consists of taking string A and moving the leftmost
    // character to the rightmost position. For example, if A = 'abcde', then it
    // will be 'bcdea' after one shift on A. Return True if and only if A can
    // become B after some number of shifts on A.
    // 判断 B 是不是 A 左移的结果。 如果 B 是 A 左移部分的结果，那么两个 B 相加，必然是包含 A 的
    /**
     * @param a
     * @param b
     * @return
     */
    public static boolean rotateString(String a, String b) {
        if (a.length() != b.length())
            return false;
        return (b + b).contains(a);
    }

    public static void main(String[] args) {
        String a = "abcdef";
        String b = "cdefab";
        System.out.println(rotateString(a, b));
    }

}
