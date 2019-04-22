package com.beng.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 输出 S 中 包含 J 的个数
 * 
 * @author apple
 */
public class NumJewelsInStones {

    // 例如 J=aA S=aAABBB
    // 输出 3
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); ++i) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); ++i) {
            char tmp = S.charAt(i);
            if (set.contains(tmp))
                ++count;
        }
        return count;
    }
}
