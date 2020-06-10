package com.future.data.structure.recursion;

/**
 * 203. 移除链表元素
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode preNode = dummyHead;
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                preNode.next = preNode.next.next;
            }else
            preNode = preNode.next;
        }

        return dummyHead.next;
    }
}
