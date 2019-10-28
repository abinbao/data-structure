package com.beng.listnode;

/**
 * @desc 链表判断是否回文
 * @author apple
 * @date 2019年10月27日
 */
public class ListNodeIsHuiWen {

    /**
     * @desc
     * @param node
     * @return
     */
    public static boolean isHuiWen(ListNode<String> node) {
        if (node == null || node.next == null)
            return true;
        ListNode<String> slow = node;// 慢指针
        ListNode<String> fast = node;// 快指针
        ListNode<String> pre = null; // 前一个节点
        while (fast != null && fast.next != null) {
            // 快指针继续走 直到找到中点
            fast = fast.next.next;
            // 慢指针翻转
            ListNode<String> next = slow.next; // 保存下一个节点指针，防止断掉
            slow.next = pre; // 将当前指针指向前一个对象
            pre = slow; // 当前指针 变成 前一个对象
            // 继续遍历
            slow = next;
        }
        // 判断奇偶
        if (fast != null) {
            slow = slow.next;
        }
        // 分为两个链表
        while (slow != null) {
            if (!slow.value.equals(pre.value)) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {

        ListNode<String> node5 = new ListNode<>(null, "h");
        ListNode<String> node4 = new ListNode<>(node5, "a");
        ListNode<String> node3 = new ListNode<>(node4, "a");
        ListNode<String> node2 = new ListNode<>(node3, "a");
        ListNode<String> node1 = new ListNode<>(node2, "a");
        // ListNode<String> node0 = new ListNode<>(node1, "h");

        System.out.println(isHuiWen(node1));

    }

}
