package com.beng.leetcode.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
 * @author apple
 * 
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
示例 1：
输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
示例 2：
输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
注意：
假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
输入的单词均由小写字母组成。
 */
public class TopKFrequent {

    /**
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>(k);
        Map<String, Integer> map = new TreeMap<>();
        for (String item : words) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = map.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())).collect(Collectors.toList());
        int index = 1;
        for (Entry<String, Integer> entry : list) {
            if (index > k)
                break;
            result.add(entry.getKey());
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr = new String[] { "i", "love", "leetcode", "i", "love", "coding" };
        System.out.println(topKFrequent(arr, 2).toString());
    }
}
