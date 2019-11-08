package com.beng.listnode;

/**
 * @desc 合并两个有序链表
 * @author apple
 * @date 2019年11月7日
 */
public class ListNodeMerge {

    public static ListNode<Integer> merge(ListNode<Integer> node1, ListNode<Integer> node2) {
        ListNode<Integer> node = null;
        ListNode<Integer> pre = null;
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        while (node1 != null && node2 != null) {
            if (node1.value >= node2.value) {
                if (node == null) {
                    node = node2;
                    pre = node;
                } else {
                    pre.next = node2;
                    pre = pre.next;
                }
                node2 = node2.next;
            } else {
                if (node == null) {
                    node = node1;
                    pre = node;
                } else {
                    pre.next = node1;
                    pre = pre.next;
                }
                node1 = node1.next;
            }
        }
        if (node2 == null) {
            pre.next = node1;
        }
        if (node1 == null) {
            pre.next = node2;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<>(null, 12);
        ListNode<Integer> node4 = new ListNode<>(node5, 9);
        ListNode<Integer> node3 = new ListNode<>(node4, 6);
        ListNode<Integer> node2 = new ListNode<>(node3, 5);
        ListNode<Integer> node1 = new ListNode<>(node2, 2);

        ListNode<Integer> nodev5 = new ListNode<>(null, 13);
        ListNode<Integer> nodev4 = new ListNode<>(nodev5, 10);
        ListNode<Integer> nodev3 = new ListNode<>(nodev4, 8);
        ListNode<Integer> nodev2 = new ListNode<>(nodev3, 4);
        ListNode<Integer> nodev1 = new ListNode<>(nodev2, 1);

        ListNode<Integer> node = merge(node1, nodev1);

        System.out.println(node);
    }
}
