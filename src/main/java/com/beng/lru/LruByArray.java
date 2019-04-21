package com.beng.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用数组实先 Lru
 * 
 * @author apple
 */
public class LruByArray<T> {

    private static final int DEFAULT_CAPACITY = 8; // 缓存默认容量
    private int capacity; // 缓存容量
    private int count; // 当前包含多少个缓存
    private T[] arr; // 缓存容器
    private Map<T, Integer> holder; // 利用hash表优化，进行映射

    public LruByArray() {
        this(DEFAULT_CAPACITY);
    }

    // 初始化
    public LruByArray(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        this.count = 0;
        holder = new HashMap<>(capacity);
    }

    // 因为使用的是数组，所以不支持 null 值
    public T offer(T object) throws IllegalAccessException {
        // 数组不能存储 null
        if (object == null)
            throw new IllegalAccessException("不支持NULL");
        // 利用 hash 表获取当前访问对象在缓存中的索引
        Integer index = holder.get(object);
        // 如果为空，说明之前没有缓存
        if (index == null) {
            // 判断缓存是否满了，如果满了，将最后一个元素删除，然后将该对象插入第一个
            if (isFull()) {
                removeAndCache(object);
            } else {
                // 没满，直接缓存，将已存在的元素右移并更新
                cache(object);
            }
        } else {
            // 如果 index 不为空，说明之前是有缓存的
            // 将前放到最前边，然后器左边的右移
            update(index);
        }
        return object;
    }

    /**
     * 判断缓存中是否包含该对象
     * 
     * @param object
     * @return
     */
    public boolean contain(T object) {
        return holder.containsKey(object);
    }

    /**
     * 存储对象
     * 
     * @param object
     */
    private void cache(T object) {
        // 将已存在的进行右移
        rightShift(count);
        // 更新元素以及hash表
        arr[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 缓存满了
     * 
     * @param object
     */
    private void removeAndCache(T object) {
        // 删除最后一个对象
        T last = arr[--count];
        holder.remove(last);
        // 缓存当前对象
        cache(object);
    }

    /**
     * 更新缓存
     * 
     * @param object
     */
    private void update(int index) {
        // 获取命中的存储对象
        T target = arr[index];
        // 然后右移其左边的存储对象
        rightShift(index);
        // 将最新访问的放到最前方
        arr[0] = target;
        // 更新 hash 表
        holder.put(target, 0);
    }

    /**
     * 数组右移，将最新的放入前边
     */
    private void rightShift(int end) {
        // 将 end 左边的数组右移
        for (int i = end - 1; i >= 0; --i) {
            arr[i + 1] = arr[i];
            holder.put(arr[i], i + 1);
        }
    }

    /**
     * 判断缓存是否为空
     * 
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 判断缓存是否已满
     * 
     * @return
     */
    public boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

}
