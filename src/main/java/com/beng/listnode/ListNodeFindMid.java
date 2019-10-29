package com.beng.listnode;

/**
 * @desc 求链表的中间节点
 * @author apple
 * @date 2019年10月29日
 */
public class ListNodeFindMid {

    public static ListNode<String> findMid(ListNode<String> head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode<String> slow = head;
        ListNode<String> fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        ListNode<String> node5 = new ListNode<>(null, "a");
        ListNode<String> node4 = new ListNode<>(node5, "b");
        ListNode<String> node3 = new ListNode<>(node4, "c");
        ListNode<String> node2 = new ListNode<>(node3, "d");
        ListNode<String> node1 = new ListNode<>(node2, "e");
        ListNode<String> node0 = new ListNode<>(node1, "f");
        ListNode<String> node = new ListNode<>(node0, "g");

        System.out.println(findMid(node));
    }
}
