package com.future.data.structure.nonlinearStructure.AVL;

/**
 * @author: zcd
 */
public class BST<E extends Comparable<E>> {
    private class Node<E> {
        E e;
        Node<E> left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private int size;
    private Node root;

    public int getSize() {
        return size;
    }

    public boolean contains(E e) {

        return contains(root, e);
    }

    private boolean contains(Node<E> node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            //right
            return contains(node.right, e);
        } else {
            //left
            return contains(node.left, e);
        }
    }

    /**
     * add element from root
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node<E> add(Node<E> node, E e) {
        if (node == null) {
            size++;
            return new Node<>(e);
        }
        if (e.compareTo(node.e) > 0) {
            //right
            node.right = add(node.right, e);
        } else {
            //left
            node.left = add(node.left, e);
        }
        return node;
    }

    public Node<E> minNode(){
        return minNode(root);
    }

    private Node<E> minNode(Node<E> node){
        if(node.left == null){
            return node;
        }
        return minNode(node.left);
    }

    public Node<E> maxNode(){
        return maxNode(root);
    }

    private Node<E> maxNode(Node<E> node){
        if(node.right == null){
            return node;
        }
        return  maxNode(node.right);
    }


    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node<E> node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node<E> node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node<E> node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        return "BST{" +
                "size=" + size +
                ", root=" + root +
                '}';
    }
}
