package com.longfei.easy;

/**
 * 反转二叉树
 *
 * @author wlf
 * @time 2021/7/6
 */
public class InvertTreeHot226 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
        }
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    /**
     * solution 1: 递归
     * 时间复杂度O(n),空间复杂度平均为O(logn)，使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。最坏情况下为O(n)
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 从上至下依次交换节点
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}    