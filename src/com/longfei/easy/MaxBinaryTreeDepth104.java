package com.longfei.easy;

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
