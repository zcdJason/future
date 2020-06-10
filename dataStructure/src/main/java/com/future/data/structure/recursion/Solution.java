package com.future.data.structure.recursion;

/**
 * 203. 移除链表元素
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null)
            return null;

        ListNode preNode = head;
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                ListNode delNode = preNode.next;
                preNode.next = delNode.next;
                delNode.next = null;
            }else
            preNode = preNode.next;
        }

        return head;
    }
}
