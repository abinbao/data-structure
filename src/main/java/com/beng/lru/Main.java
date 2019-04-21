package com.beng.lru;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        LruByArray<Integer> lru = new LruByArray<>();
        int[] arr = new int[] { 1, 2, 6, 7, 7, 1, 13, 19, 20, 1, 8, 6, 33, 42 };
        test(lru, arr);
    }

    private static void test(LruByArray<Integer> lru, int[] arr) throws IllegalAccessException {
        for (int i : arr) {
            lru.offer(i);
            System.out.println(lru);
        }
    }
}
