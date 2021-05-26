package com.longfei.medium;

/**
 * @author wlf
 * @time 2021/5/26
 * 删除链表倒数第n个节点
 */
public class RemoveNthFromEndHot19 {
    
    /**
     * 方案1：计算长度，找到对应节点再删除
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int length = getLength(head);
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy; // 指向而不是new
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode res = dummy.next;
        return res;
    }
    
    public static int getLength(ListNode n) {
        int l = 0;
        while (n != null) {
            l++;
            n = n.next;
        }
        return l;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}    