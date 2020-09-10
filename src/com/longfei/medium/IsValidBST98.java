package com.longfei.medium;

/**
 * 验证二叉搜索树
 *
 * @author islongfei
 * @date 2020.09.10
 */
public class IsValidBST98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // solution 1. BST 中序遍历是递增的
    // solution 2. 递归

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 判断当前节点是否是大于上一节点
        if (root.val <= pre) {
            return false;
        }

        pre = root.val;

        // 访问右子树
        return isValidBST(root.right);
    }
}
