package com.beng.leetcode.linkedList;

/**
 * 链表结点
 * 
 * @author apple
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int val() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode next() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append("ListNode [val=" + head.val + "] -> ");
            head = head.next;
        }
        sb.append("null");
        return sb.toString();
    }

}
