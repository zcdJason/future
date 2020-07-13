package com.future.data.structure.nonlinearStructure.AVL;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zcd
 * <p>
 * 对于任意一个节点，它的左右子树高度查不超过1（<=1)r
 */
public class AvlTree<K extends Comparable<K>, V> {
    //记录一个节点的高度
    private class Node {
        K key;
        V value;
        int height; //节点的高度
        Node left, right;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
            this.height = 1;
            this.left = this.right = null;
        }
    }

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    private int getHeight(Node node) {
        if (node == null)
            return 0; //如果节点为空，返回高度为0；
        return node.height;
    }

    /**
     * 使用节点的高度来计算节点的平衡因子
     * 平衡因子是节点的左右子树高度差,它的作用是为了自平衡（如高度差 >1)
     */
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    public Node getNode(K key) {
        return getNode(root, key);
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException("node is does't exist!");
        node.value = value;
    }

    public V remove(K key) {
        Node node = getNode(key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return node;
        }

        Node retNode;

        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else {
            if (node.left == null) {
                Node nodeRight = node.right;
                node.right = null;
                size--;
                retNode = nodeRight;
            } else if (node.right == null) {
                Node nodeLeft = node.left;
                node.left = null;
                size--;
                retNode = nodeLeft;
            }else{
                //has right and left node
                Node successor = minNode(node.right);
                successor.left = node.left;
                successor.right = removeMin(node.right, key);
                node.left = node.right = null;
                retNode = successor;
            }
        }

        if(retNode == null)
            return  null;
        //更新高度
        retNode.height = 1 + Math.max(getHeight(retNode.right), getHeight(retNode.left));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
            return rightRotate(retNode);

        if(balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
            return leftRotate(retNode);

        if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
           retNode.left = leftRotate(retNode.left);
           return rightRotate(retNode);
        }

        if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }

    private Node removeMin(Node node, K key) {
        if (node.left == null) {
            Node nodeRight = node.right;
            node.right = null;
            size--;
            return nodeRight;
        }
        node.left = removeMin(node.left, key);
        return node;
    }

    private Node minNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return minNode(node.left);
    }

    //判断是否是二分搜索树
    private boolean isBST() {
        //定义一个数组列表，存储k值，如果是二分搜索树，那么树的中序遍历将会是有序的
        List<K> keyList = new ArrayList<>();
        inOrder(root, keyList);
        for (int i = 1; i < keyList.size(); i++) {
            if (keyList.get(i - 1).compareTo(keyList.get(i)) > 0)
                return false;
        }
        return true;
    }

    public void inOrder(Node node, List<K> keyList) {
        if (node == null)
            return;
        inOrder(node.left, keyList);
        keyList.add(node.key);
        inOrder(node.right, keyList);
    }

    //判断是否是AVL树
    public boolean isAVLTree() {
        return isAVLTree(root);
    }

    //判断平衡因子是否有 > 1 的
    private boolean isAVLTree(Node node) {
        //1:递归基线
        if (node == null)
            return true;

        //2：处理逻辑
        int balanceFactor = Math.abs(getBalanceFactor(node));
        if (balanceFactor > 1)
            return false;

        //3：在哪儿递归
        return isAVLTree(node.left) && isAVLTree(node.right);
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        node                           x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     node
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node node) {
        Node x = node.left;
        Node t3 = x.right;

        x.right = node;
        node.left = t3;

        //更新高度；此时只需要更新y和x的高度就可以了；注意更新的顺序是先Y，后x
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        x.height = 1 + Math.max(getHeight(x.right), getHeight(x.left));
        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node node) {
        Node x = node.right;
        Node T2 = x.left;

        x.left = node;
        node.right = T2;

        //更新高度；此时只需要更新y和x的高度就可以了；注意更新的顺序是先Y，后x
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        x.height = 1 + Math.max(getHeight(x.right), getHeight(x.left));
        return x;
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            node.value = value;
        }

        //更新节点高度，当前节点高度是它左右子树最大高度+1
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        //balanceFactor
        int balanceFactor = getBalanceFactor(node);
        //平衡调整 LL情况
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            //右旋转
            return rightRotate(node);
        //RR情况
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            //左旋转
            return leftRotate(node);

        //        y                              y                      z
        //       / \                            / \                   /   \
        //      x   T4     先对y的左孩子x进行左旋转 z  T4 然后右旋转       x     y
        //     / \       - - - - - - - ->     /  \    ------->     / \   / \
        //    t   Z                          x    T2              t  T1 T2 T4
        //       / \                        / \
        //      T1 T2                      t  T1
        // LR 情况
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL 情况
        if(balanceFactor <-1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
}
