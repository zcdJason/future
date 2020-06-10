package com.future.data.structure.nonlinearStructure.binarySearchTree;

/**
 * binary search tree
 */
public class BST<E extends Comparable<E>> {
    private class Node<E>{
        E e;
        Node<E> left, right;
        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    Node<E> root;
    int size;

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean add(E e){
        if(root == null)
        {
            root = new Node<>(e);
            return true;
        }else{
            return  add(root, e);
        }
    }

    public boolean add(Node<E> node, E e){
        if(e.equals(node.e)){
            return false;
        }else if(e.compareTo(node.e) > 0 && node.right == null)
        {
            node.right = new Node<>(e);
            size ++;
            return true;
        }else if(e.compareTo(node.e) < 0 && node.left == null)
        {
            node.left = new Node<>(e);
            size ++;
            return true;
        }

        if(e.compareTo(node.e) > 0)
            add(node.right, e);
        else
            add(node.right, e);
        return  true;
    }
}
