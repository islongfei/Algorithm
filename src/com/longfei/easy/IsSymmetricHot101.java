package com.longfei.easy;

/**
 * 是否为对称二叉树
 *
 * @author wlf
 * @time 2021/7/6
 */
public class IsSymmetricHot101 {
    
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
     * solution 1: 双指针
     * 时间复杂度 O(n),空间复杂度 平均为O(logn)
     * 空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        // 双指针
        return check(root, root);
    }
    
    public boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (l == null || r == null) {
            return false;
        }
        // 校验双指针节点是否相等，校验双指针的子节点是否对称相等
        return l.val == r.val && check(l.left, r.right) && check(l.right, r.left);
    }
}    