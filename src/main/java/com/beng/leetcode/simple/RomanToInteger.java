package com.beng.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link https://leetcode.com/problems/roman-to-integer/}
 * 
 * @author apple
 */
// Symbol Value
// I 1
// V 5
// X 10
// L 50
// C 100
// D 500
// M 1000
// I can be placed before V (5) and X (10) to make 4 and 9.
// X can be placed before L (50) and C (100) to make 40 and 90.
// C can be placed before D (500) and M (1000) to make 400 and 900.
public class RomanToInteger {

    private static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    /**
     * @desc 有点像链表，记录前一个字符串和后面的字符串进行比较
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;
        String[] str = s.split("");
        String pre = "M";
        int result = 0;
        for (String i : str) {
            if (map.get(i) > map.get(pre))
                result = result + map.get(i) - 2 * map.get(pre);
            else
                result = result + map.get(i);
            pre = i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
