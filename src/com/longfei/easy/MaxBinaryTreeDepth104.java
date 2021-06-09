package com.longfei.easy;

/**
 * 二叉数的最大深度
 */
public class MaxBinaryTreeDepth104 {

    public int maxDepth(TreeNode root) {

        return root == null ? 0 : Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
