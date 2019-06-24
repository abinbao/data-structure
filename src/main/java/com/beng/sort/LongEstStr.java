package com.beng.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续子序列的长度
 * 
 * @author apple
 */
public class LongEstStr {
    public static int getLongest(int[] strs) {
        int max = 0;
        int oldmax = 0;
        for (int i = 1; i < strs.length; ++i) {
            if (strs[i] - strs[i - 1] == 1) {
                max = max + 1;
                oldmax = max;
            } else {
                max = 0;
            }
        }
        return Math.max(max, oldmax);
    }

    public static int getLongestV2(int[] strs) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int str : strs) {
            // 0 表示没有处理过
            if (map.getOrDefault(str, 0) == 0) {
                int left = map.getOrDefault(str - 1, 0); // 左序列长度
                int right = map.getOrDefault(str + 1, 0); // 右序列长度
                map.put(str, right + left + 1);
                // 设置左端点
                if (left != 0) {
                    map.put(str - left, left + right + 1);
                }
                // 设置右端点
                if (right != 0) {
                    map.put(str + right, right + left + 1);
                }
                max = max > (left + right + 1) ? max : (left + right + 1);
            }
        }
        return max;
    }
}
