package com.future.data.structure.nonlinearStructure.RedBlackTree;

import com.future.data.structure.nonlinearStructure.AVL.FileOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

/**
 * @author: Cock a doodle doo
 * 统计性能更优的树
 */
public class RedBlackTree<K extends Comparable<K>, V> {
    private static final boolean RED = true; //需要进行融合的节点用红色表示
    private static final boolean BLACK = false;
    private class Node {
        K key;
        V value;
        Node left, right;
        boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
            this.color = RED;
        }
    }

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public  boolean isRed(Node node) {
        if(node == null)
            return BLACK;
        return node.color;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    //检查是否是二分搜索树，二分搜索树的特点是中序遍历是有序的
    public boolean isBST() {
        List<K> keyList = inOrder();
        for (int i = 1; i < keyList.size(); i++) {
            if (keyList.get(i - 1).compareTo(keyList.get(i)) > 0)
                return false;
        }
        return true;
    }

    public void  set(K key, V value){
        Node node = getNode(key);
        if(node == null)
            throw new IllegalArgumentException("node does't exist!");
        node.value = value;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;//保持根节点为黑色的
    }

    public boolean contains(K key) {
        return getNode(key) != null;
    }

    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    public Node getNode(K key) {
        return getNode(root, key);
    }

    private Node getNode(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return getNode(node.left, key);
        }
    }

    public List<K> inOrder() {
        List<K> keyList = new ArrayList<>();
        inOrder(root, keyList);
        return keyList;
    }

    private void inOrder(Node node, List<K> keyList) {
        if (node == null)
            return;

        inOrder(node.left, keyList);
        keyList.add(node.key);
        inOrder(node.right, keyList);
    }

//    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
//    //        y                              x
//    //       / \                           /   \
//    //      x   T4     向右旋转 (y)        z     y
//    //     / \       - - - - - - - ->    / \   / \
//    //    z   T3                       T1  T2 T3 T4
//    //   / \
//    // T1   T2
//    private Node rightRotate(Node y) {
//        Node x = y.left;
//        Node T3 = x.right;
//
//        x.right = y;
//        y.left = T3;
//
//        //调整高度
//        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
//        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
//
//        return x;
//    }


    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4

//    private Node leftRotate(Node y) {
//        Node x = y.left;
//        Node T2 = x.left;
//
//        x.left = y;
//        y.right = T2;
//
//        //调整高度
//        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
//        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
//
//        return x;
//    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node){
        Node  x = node.right;
        //左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;//表示需要和父节点进行融合
        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node){
        Node x = node.left;
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED; //表示需要和父节点进行融合
        return  x;
    }

    //颜色翻转
    private void flipColor(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }


    public Node remove(K key) {
        return remove(root, key);
    }

    private Node getMinNode(Node node) {
        if (node.left == null)
            return node;
        return getMinNode(node.left);
    }

    private Node removeMinNode(Node node) {
        if (node.left == null) {
            Node tmp = node.right;
            size--;
            tmp.right = null;
            return tmp;
        }

        node.left = removeMinNode(node.left);
        return node;
    }


    //todo 这里没有实现红黑树的删除节点颜色的维护
    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                size--;
                node.right = null;
                return  rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                size--;
                node.left = null;
                return  leftNode;
            }
                Node successor = getMinNode(node);
                successor.left = node.left;
                successor.right = removeMinNode(node.right);
                return successor;

        }
    }

    //添加一个节点返回根节点
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) == 0)
            node.value = value;
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else
            node.left = add(node.left, key, value);

        //右孩子红色 并且 左孩子不是红色  左旋转
        if(isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);

        //左孩子红色 ，左孩子的孩子是红色 进行右旋转
        if(isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);

        //左孩子红色和右孩子都是红色，进行颜色翻转
        if(isRed(node.left) && isRed(node.right))
            flipColor(node);

        return node;
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("/Users/zcd/files/NewX/future/dataStructure/src/main/resources/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            RedBlackTree<String, Integer> map = new RedBlackTree<>();
            Long startTime = System.nanoTime();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            Long endTime = System.nanoTime();

            System.out.println();
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

}
