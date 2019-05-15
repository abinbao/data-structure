package com.beng.leetcode.treenode;

/**
 * 获取二叉树的最大深度
 * 
 * @author apple
 */
public class MaxDepth {
    /**
     * Definition for a binary tree node. public class TreeNode { int val;
     * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    public static int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int depth) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return Math.max(dfs(root.left, depth) + 1, dfs(root.right, depth) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(2);
        TreeNode left_left = new TreeNode(3);
        TreeNode left_right = new TreeNode(4);
        left.left = left_left;
        left.right = left_right;
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(maxDepth(root));
    }
}
