package com.beng.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 ArrayList 性能
 * 
 * @author apple
 */
public class TestArrayList {

    public static void main(String[] args) {
        // 在添加 非基础类型（int, long）时, 提前申请好 ArrayList 的 size，再进行添加的效率会更高
        long st = System.currentTimeMillis();
        List<String> list = new ArrayList<>(10000000);
        for (int i = 0; i < 10000000; ++i) {
            list.add("");
        }
        System.out.println("Test1: " + (System.currentTimeMillis() - st));
        long s1 = System.currentTimeMillis();
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 10000000; ++i) {
            list1.add("");
        }
        System.out.println("Test2: " + (System.currentTimeMillis() - s1));
        // 测试 List 中添加 Integer 类型
        testInteger();
    }

    // 往 List 添加Integer时，需要不停的拆箱、封箱操作，效率变低。 但是不明白为什么这里 效率是反过来的？
    public static void testInteger() {
        long st = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>(10000000);
        for (int i = 0; i < 10000000; ++i) {
            list.add(i);
        }
        System.out.println("Test1: " + (System.currentTimeMillis() - st));
        long s1 = System.currentTimeMillis();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10000000; ++i) {
            list1.add(i);
        }
        System.out.println("Test2: " + (System.currentTimeMillis() - s1));
    }

}
