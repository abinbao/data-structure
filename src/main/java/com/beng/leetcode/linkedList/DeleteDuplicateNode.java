package com.beng.leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author apple
 * @desc 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @example 输入: 1->1->2 输出: 1->2
 */
public class DeleteDuplicateNode {

    /**
     * @desc 刚开始的思路： 就是用一个集合来保存当前的值是否出现过
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = head;
        ListNode pre = null;
        Set<Integer> set = new HashSet<>();
        while (current != null) {
            if (!set.contains(current.val)) {
                set.add(current.val);
                pre = current; // 保存前一个结点，防止指针丢失
                current = current.next;
            } else {
                pre.next = current.next;
                current = pre.next;
            }
        }
        return head;
    }

    /**
     * @desc 发现上一种方法完全没有必要去那样，应为链表是已经排序好的了，并且已知前一个节点的当前的节点，可以直接进行比较
     * @annotation 注意在head为 null 的情况和链表只有一个节点的情况
     * @param head
     * @return
     */
    public static ListNode deleteDuplicatesV1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            if (pre == null || pre.val != current.val) {
                pre = current;
                current = current.next;
            } else {
                pre.next = current.next;
                current = pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        deleteDuplicatesV1(node1);
        System.out.println(node1.toString());
    }
}
