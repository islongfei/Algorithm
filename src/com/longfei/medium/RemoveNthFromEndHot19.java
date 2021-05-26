package com.longfei.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wlf
 * @time 2021/5/26
 * 删除链表倒数第n个节点
 */
public class RemoveNthFromEndHot19 {
    
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
    
    /**
     * 方案1：计算长度，找到对应节点再删除
     * 时间复杂度：O(n)，其中 n 是链表的长度。
     * 空间复杂度：O(1)。
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
    
    /**
     * 方案2 不用计算长度，利用栈后进先出的特性找到目标节点
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        Deque<ListNode> stack = new LinkedList<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prve = stack.peek();
        //还是引用，找个这个节点的前一个节点无脑next = next.next
        prve.next = prve.next.next;
        return dummy.next;
    }
    
    /**
     * 方案3：
     * 双指针：第一个指针先往前遍历到n时，此时第二个指针开始从头和第一个指针一起遍历，
     * 等第一个指针遍历到末尾时，第二个指针刚好到（length -n处），也就是倒数第n
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}    