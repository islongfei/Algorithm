package com.longfei.Template;

/**
 * @author wlf
 * @time 2021/5/26
 * 链表工具类
 */
public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode(int x) {
        val = x;
    }
    
    /**
     * 重写了toString方法，方便调试时能够直接输出
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        ListNode current = this;
        while (current != null) {
            s = s + " " + current.val;
            current = current.next;
        }
        return s;
    }
    
    public static ListNode initList(int... vals) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int val : vals) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return head.next;
    }
    
    public static void main(String[] args) {
        System.out.println(initList(1, 2, 3).toString());
    }
    
}