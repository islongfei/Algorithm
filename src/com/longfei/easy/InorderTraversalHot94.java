package com.longfei.easy;

import java.util.*;

/**
 * 二叉树的中序遍历
 *
 * @author wlf
 * @time 2021/7/6
 */
public class InorderTraversalHot94 {
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
     * solution 1 : 递归，时间复杂度O(n)，空间复杂度O(n)
     * 空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root);
        return res;
    }
    
    private void inorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历按照 左根右的顺序
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }
    
    /**
     * solution 2 :迭代，模拟出一个栈，时间复杂度O(n)，空间复杂度O(n)
     * 区别在于递归的时候隐式地维护了一个栈，而迭代的时候需要显式地将这个栈模拟出来
     * 现代计算机递归和迭代性能上差别不大
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left; //左节点依次压栈
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right; //如果右节点为空，会继续从栈中拿上一个树的节点（根节点）。当遍历到右节点，右节点的子左节点为空，会继续从栈中拿树的上一个左节点
            
        }
        return res;
    }
    
    /**
     * solution 3：Morris 遍历，时间复杂度O(n)，空间复杂度O(1)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return res;
    }
    
}