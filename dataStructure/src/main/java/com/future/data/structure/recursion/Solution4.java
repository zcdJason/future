package com.future.data.structure.recursion;

/**
 * 203. 移除链表元素
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * 递归解决问题
 * 问题是移除链表中可能存在的所有元素；
 * 因此运用递归会将所有元素押入调用函数栈，（占用内存比较大）
 * 运用递归有两个需要注意，递归的基线（即递归何时结束），第二是什么情况下递归
 * 这儿，只要节点为空节点就结束递归
 * 条件，比较元素是否相同，如果相同则将元素删除，即当前节点的next指向删除节点的next，否则它的next即为节点本身
 */
public class Solution4 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        head.next = removeElements(head.next, val);
        return  head.val == val ? head.next : head;
    }
}
