package com.beng.leetcode.recursion;

/*
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * @author apple
 * @desc 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
注意：两个节点之间的路径长度由它们之间的边数表示。
示例 1:
输入:
              5
             / \
            4   5
           / \   \
          1   1   5
输出:
2
示例 2:
输入:
              1
             / \
            4   5
           / \   \
          4   4   5
输出:
2
注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。

 */
public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = 0;
        int right = 0;
        if (root.left != null && root.val == root.left.val) {
            left = Math.max(longestUnivaluePath(root.left) + 1, longestUnivaluePath(root.right));
        }

        if (root.right != null && root.val == root.right.val) {
            right = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right) + 1);
        }
        return Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
