package com.beng.leetcode.stack;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author apple
 * @desc 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
 */
public class IsValidByStack {

    /**
     * 利用栈的特性，注意各种边界条件与判空条件
     * 
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.equals("") || s == null)
            return true;
        if (s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[')
                stack.push(temp);
            else {
                if (!stack.isEmpty()) {
                    if (temp == ')' && stack.pop() != '(') {
                        return false;
                    }
                    if (temp == ']' && stack.pop() != '[') {
                        return false;
                    }
                    if (temp == '}' && stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
