package com.beng.listnode;

/**
 * @desc 单链表翻转
 * @author apple
 * @date 2019年10月28日
 */
public class ListNodeReverse {

    public static void reverse(ListNode<String> node) {
        if (node == null || node.next == null)
            return;

        ListNode<String> pre = null;
        while (node != null) { // 注意这个条件是 node != null, 如果是 node.next != null,
                               // 会丢到最后一个指针
            // 保存指针，防止断链
            ListNode<String> cur = node.next;
            node.next = pre;
            pre = node;
            // 继续遍历
            node = cur;
        }
    }

    public static void main(String[] args) {
        ListNode<String> node5 = new ListNode<>(null, "a");
        ListNode<String> node4 = new ListNode<>(node5, "b");
        ListNode<String> node3 = new ListNode<>(node4, "c");
        ListNode<String> node2 = new ListNode<>(node3, "d");
        ListNode<String> node1 = new ListNode<>(node2, "e");
        ListNode<String> head = node1;
        while (head != null) {
            System.out.println(head.toString());
            head = head.next;
        }
        reverse(node1);
        while (node5 != null) {
            System.out.println(node5.toString());
            node5 = node5.next;
        }
    }
}
