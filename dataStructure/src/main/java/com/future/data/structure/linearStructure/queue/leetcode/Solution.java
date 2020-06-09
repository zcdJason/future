package com.future.data.structure.linearStructure.queue.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Leetcode 102. Binary Tree Level Order Traversal
//使用队列来辅助二叉树的层序遍历
public class Solution {
    //leetcode需要将类和接口放到Solution外部，否则编译不通过
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    private interface IQueue<E> {
        //入队
        void enqueue(E e);

        //出队
        E dequeue();

        //获取队首元素
        E getFont();

        //获取队列长度
        int getSize();

        //队列空判断
        boolean isEmpty();
    }

    public class MyLoop2Queue<E> implements IQueue<E> {
        E[] data;
        //队首索引
        int font;
        //队尾索引
        int tail;
        //队元素个数
        int size;

        public MyLoop2Queue() {
            this(4);
        }

        public MyLoop2Queue(int capacity) {
            data = (E[]) new Object[capacity];
            font = 0;
            tail = 0;
            size = 0;
        }

        @Override
        public void enqueue(E e) {
            if (isFull())
                resize(getCapacity() * 2);
            data[tail] = e;
            tail = (tail + 1) % data.length;
            size++;
        }

        private void resize(int capacity) {

            E[] newData = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(font + i) % data.length];
            }
            font = 0;
            tail = size;
            data = newData;
        }

        @Override
        public E dequeue() {
            if (isEmpty())
                throw new IllegalArgumentException("cannot dequeue element, queue is empty");
            if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
                resize(getCapacity() / 2);
            }
            E res = data[font];
            data[font] = null;
            font = (font + 1) % data.length;
            size--;
            return res;
        }

        @Override
        public E getFont() {
            return data[font];
        }

        @Override
        public int getSize() {
            return size;
        }

        private boolean isFull() {
            return size == getCapacity();
        }

        public int getCapacity() {
            return data.length;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public String toString() {
            return "MyLoop2Queue{" +
                    "data=" + Arrays.toString(data) +
                    ", font=" + font +
                    ", tail=" + tail +
                    ", size=" + size +
                    '}';
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root)
            return res;
        MyLoop2Queue<Pair<TreeNode, Integer>> loopQueue = new MyLoop2Queue<Pair<TreeNode, Integer>>();
        loopQueue.enqueue(new Pair<TreeNode, Integer>(root, 0));

        while (!loopQueue.isEmpty()) {
            Pair<TreeNode, Integer> font = loopQueue.dequeue();
            TreeNode node = font.getKey();
            int level = font.getValue();

            int val = node.val;
            if (level == res.size())
                res.add(new ArrayList<>());
            res.get(level).add(val);

            if (node.left != null)
                loopQueue.enqueue(new Pair<TreeNode, Integer>(node.left, level + 1));
            if (node.right != null)
                loopQueue.enqueue(new Pair<TreeNode, Integer>(node.right, level + 1));
        }
        return res;
    }

//    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(3);
//        TreeNode t2 = new TreeNode(9);
//        TreeNode t3 = new TreeNode(20);
//        TreeNode t4 = new TreeNode(15);
//        TreeNode t5 = new TreeNode(7);
//        t1.left = t2;
//        t1.right = t3;
//        t3.left = t4;
//        t3.right = t5;
//        Solution s1 = new Solution();
//        List<List<Integer>> tt = s1.levelOrder(t1);
//        System.out.println(tt);
//    }
}
