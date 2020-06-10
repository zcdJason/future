package com.future.data.structure.nonlinearStructure.binarySearchTree;

public class BST2<E extends Comparable<E>> {
    private class Node<E> {
        E e;
        Node<E> left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    Node<E> root;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node<>(e);
        } else {
            add(root, e);
        }
    }

    public void add(Node<E> node, E e) {
        //基线
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node<>(e);
            size++;
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node<>(e);
            size++;
            return;
        }

        //递归条件
        if (e.compareTo(node.e) > 0) {
            add(node.right, e);
        } else {
            add(node.left, e);
        }
    }
}
