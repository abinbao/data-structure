package com.beng.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到链表的中点 一个快指针 一个慢指针
 * 
 * @author apple
 */
public class MiddleNode {

    // 快慢指针
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 利用 hash 表
    public ListNode middleNodeV2(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int i = 1;
        while (slow != null) {
            map.put(i, slow);
            ++i;
            slow = slow.next;
        }
        if (i % 2 == 0)
            return map.get(i / 2);
        else
            return map.get(i / 2 + 1);
    }
}
