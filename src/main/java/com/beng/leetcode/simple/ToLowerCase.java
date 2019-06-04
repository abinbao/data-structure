package com.beng.leetcode.simple;

/**
 * {@link https://leetcode.com/problems/to-lower-case/} 不要使用函数
 * 
 * @author apple
 */
public class ToLowerCase {

    /**
     * A = 65 a = 97 ASCII 码 小写字母在大写字母的后面 相差 32
     * 
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        if (str == null)
            return str;
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            // 大写字母的范围
            if ((c - 0) >= 65 && (c - 0 <= 90)) {
                sb.append(Character.toChars(c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("aB"));
    }

}
