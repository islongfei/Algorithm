package com.longfei.easy;

/**
 * 判断链表是否有环
 * 时间复杂度O(n),空间复杂度O(1)
 */
public class LinkedListHasCycle141 {


    /**
     * solution 1. 暴力解法 哈希表存走过的节点，重复则有环
     *
     * solution 2. 快慢指针法
     * 使用两个指针p1和p2，
     * p1每次向前移动一个节点，p2每次向前移动两个节点，
     * 如果链表有环，那么p1 p2肯定会相遇，比较两个指针指向节点是否相同即可。
     * 类似与两个运动员在环形跑道赛跑，当快者领先慢者一圈时，两人此时肯定会相遇。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;//p2每次移动两步
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

    }
}

