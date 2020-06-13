package com.future.data.structure.nonlinearStructure.binarySearchTree;

public class BST4Overwrite<E extends Comparable<E>> {
    private static class Node<E> {
        E e;
        Node<E> left, right;

        public Node(E e) {
            this.e = e;
            this.left = this.right = null;
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

    //define root
    Node<E> root;

    //define size
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node<E> add(Node<E> node, E e) {
        if (node == null)
            return new Node<>(e);

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node<E> node, E e) {
        //递归结束条件
        if (node == null) {
            return false;
        }
        //如果匹配则返回true
        if (e.compareTo(node.e) == 0) {
            return true;
        }else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }else  {
            return contains(node.right, e);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node<E> node)
    {
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node<E> node)
    {
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    private void postOrder(Node<E> node)
    {
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void inOrder(){
        inOrder(root);
    }

    public void postOrder(){
        postOrder(root);
    }

    public  Node minNode(){
        return  minNode(root);
    }

    private Node minNode(Node node){
        if(node.left == null)
            return node;
        return minNode(node.left);
    }

    public Node maxNode(){
        return maxNode(root);
    }

    private Node maxNode(Node node){
        if(node.right == null)
            return  node;

        return maxNode(node.right);
    }

    public Node remove(E e){
        return remove(root, e);
    }

    private Node remove(Node<E> node, E e){
        if(node == null)
            return null;

        if(e.compareTo(node.e) == 0)
        {
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            //否则含有左右子树的情况
            //此时 1-找出右子树最小节点为继承者；2-删除右子树最小节点并返回待删除子树的根节点；3-组合继承者的左右子树
            Node successor = minNode(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return  successor;

        }else if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
        }else{
            node.right = remove(node.right ,e);
        }

        return  node;
    }

    private Node removeMin(Node<E> node) {
        if(node.left == null)
        {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return  rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }
}
