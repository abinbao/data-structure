package com.beng.array;

/**
 * 1）数组的插入、查找和按照下标进行访问 2）数组中的数据是int类型
 * https://github.com/wangzheng0822/algo/blob/master/java/05_array/GenericArray.java
 * 
 * @author apple
 */
public class MyArray {

    private int[] data;
    private int n; // 数组长度
    private int count; // 定义中实际个数

    public MyArray(int n) {
        this.data = new int[n];
        this.n = n;
        this.count = 0;
    }

    // 根据下标进行查找
    public int find(int index) {
        if (index < 0 || index > count) {
            return -1;
        }
        return data[index];
    }

    // 插入元素，头插和尾插
    public boolean insert(int target, int value) {

        // 数组空间已满
        if (count == n) {
            System.out.println("数组空间已满.");
            return false;
        }
        if (target < 0 || target > count) {
            System.out.println("插入位置不合法.");
            return false;
        }
        // 从插入位置开始，向后移动一位
        for (int i = count; i > target; --i) {
            data[i] = data[i - 1];
        }
        data[target] = value;
        ++count;
        return true;
    }

    // 删除元素
    public boolean delete(int index) {
        if (index < 0 || index > count) {
            return false;
        }
        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArray array = new MyArray(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        // array.insert(3, 11);
        array.printAll();
    }
}
