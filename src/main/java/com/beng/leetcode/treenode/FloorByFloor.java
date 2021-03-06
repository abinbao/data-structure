package com.beng.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * N ✘ 树的层序遍历
 * 
 * @author apple
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class FloorByFloor {

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedBlockingQueue<>();
        if (root == null)
            return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; ++i) {
                Node node = queue.poll();
                l.add(node.val);
                if (node.children != null && !node.children.isEmpty()) {
                    for (Node item : node.children) {
                        queue.add(item);
                    }
                }
            }
            result.add(l);
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;

        List<Node> list = new ArrayList<>();
        Node node1 = new Node();
        node1.val = 3;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 4;
        list.add(node1);
        list.add(node2);
        list.add(node3);
        root.children = list;
        List<Node> list1 = new ArrayList<>();
        Node node4 = new Node();
        node4.val = 5;
        Node node5 = new Node();
        node5.val = 6;
        list1.add(node4);
        list1.add(node5);
        node1.children = list1;

        System.out.println(levelOrder(root));
    }
}
