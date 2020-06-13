package com.future.data.structure.nonlinearStructure.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode {
    private static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public static List<Integer> res = new ArrayList<>();



    public List<Integer> preorderTraversal(TreeNode node) {
        if(node != null){
            res.add(node.val);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
        return  res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = null;
        t1.right = t2;
        t2.left = t3;
        t3.right = null;
        LeetCode lc = new LeetCode();
        lc.preorderTraversal(t1);
        System.out.println(res);
    }
}