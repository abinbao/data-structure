package com.beng.listnode;

/**
 * @desc 链表节点
 * @author apple
 * @date 2019年10月27日
 */
public class ListNode<T> {

    public ListNode next;

    public T value;

    @Override
    public String toString() {
        return "ListNode [next=" + next + ", value=" + value + "]";
    }

    public ListNode(ListNode next, T value) {
        this.next = next;
        this.value = value;
    }

}