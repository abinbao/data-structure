package com.beng.leetcode.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 找到小镇的法官
 * 
 * @link leetcode 997
 * @author apple
 */
public class FindJudge {

    public static int findJudge(int N, int[][] trust) {
        Map<Integer, Integer> output = new HashMap<>(); // 出度
        Map<Integer, Integer> input = new HashMap<>(); // 入度

        for (int n = 1; n <= N; ++n) {
            output.put(n, 0);
            input.put(n, 0);
        }
        for (int i = 0; i < trust.length; ++i) {
            int[] arr = trust[i];
            output.put(arr[1], output.get(arr[1]) + 1);
            input.put(arr[0], input.get(arr[0]) - 1);
        }
        for (Entry<Integer, Integer> entry : output.entrySet()) {
            int key = entry.getKey();
            if (entry.getValue() == N - 1 && input.get(key) == 0)
                return key;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } };
        System.out.println(findJudge(3, trust));
    }
}
