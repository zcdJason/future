package com.future.data.structure.map;

public class BSTMap<K extends Comparable<K>, V> implements IMap<K, V> {
    private class Node {
        K k;
        V v;
        Node left;
        Node right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = this.right = null;
        }
    }

    int size;
    Node root;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    private Node getNode(Node node, K k) {
        if (node == null) {
            return null;
        }
        if (k.compareTo(node.k) == 0) {
            return node;
        } else if (k.compareTo(node.k) < 0) {
            return getNode(node.left, k);
        } else {
            return getNode(node.right, k);
        }
    }

    private Node add(Node node, K k, V v) {
        if (node == null) {
            return new Node(k, v);
        }
        int cp = k.compareTo(node.k);

        if (cp < 0) {
            node.left = add(node.left, k, v);
        } else if (cp > 0) {
            node.right = add(node.right, k, v);
        } else {
            node.v = v;
        }
        return node;
    }

    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node minNode(Node node){
        if(node.left == null){
            //找到最小节点了
            return node;
        }
        return minNode(node.left);
    }

    private Node remove(Node node, K k) {
        if (node == null) {
            return null;
        }
        int cp = node.k.compareTo(k);
        if (cp == 0) {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }

            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            //同时含有左右子数；需要维持BST数特性
            //找到右子数最小作为继承者，删除它，继承者的左是待删节点的左， 继承者的右是待删节点的右
            Node successor = minNode(node);
            successor.left = node.left;
            successor.right = removeMin(node);
            node.right = node.left = null;
            return successor;
        } else if (cp > 0) {
            node.right = remove(node.right, k);
            return node;
        } else {
            node.left = remove(node.left, k);
            return node;
        }
    }

    /**
     * 删除最小节点，返回根
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if(node.left == null){
            Node right = node.right;
            node.right = null;
            size --;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K k) {
        return null;
    }

    @Override
    public boolean isContainsKey(K k) {
        Node node = getNode(root, k);
        return node != null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(root, k);
        return node == null ? null : node.v;
    }

    @Override
    public void set(K k, V newVal) {
        Node node = getNode(root, k);
        if (node == null)
            throw new IllegalArgumentException("key not exits");
        node.v = newVal;
    }
}
