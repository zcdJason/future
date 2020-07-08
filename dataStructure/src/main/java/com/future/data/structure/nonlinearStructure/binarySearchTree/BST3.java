package com.future.data.structure.nonlinearStructure.binarySearchTree;

public class BST3<E extends Comparable<E>> {
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
        root = add(root, e);
    }

    public Node<E> add(Node<E> node, E e) {
        if (node == null) {
            size++;
            return new Node<>(e);
        }

        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else {
            node.left = add(node.left, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    public boolean contains(Node<E> node, E e) {
        if (node == null) {
            return false;
        }

        if (node.e.equals(e)) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.left, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 返回最小节点
     * @param node
     * @return
     */
    public Node minNode(Node node){
        if(node.left == null)
            return  node;
        return minNode(node.left);
    }

    /**
     * 返回最大节点
     * @param node
     * @return
     */
    public Node maxNode(Node node){
        if(node.right == null)
            return  node;
        return  maxNode(node.right);
    }

    /**
     * 删除以node为根的最小节点；返回根
     * @param node
     * @return
     */
    public Node removeMin(Node node){
        //找到最小节点
        if(node.left == null){
            //保存右子树
            Node rightNode = node.right;
            node.right = null;
            size --;
            return  rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


    public Node remove(Node<E> node, E e) {
        if (node == null)
            return null;

        if(e.compareTo(node.e) < 0)
        {
            node.left = remove(node.left, e);
            return  node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return  node;
        }else{
//            e.compareTo(node.e) equal
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

            //否则含有左右子节点的情况
            //1。找出右子树中 最小节点；
            //2。将右子树最小节点作为继承者
            //3。删除最小节点返回待删除子树的根节点
            //4。继承者的右子树为 删除节点的右子树，左子树为 删除节点的左子树
            Node  successor = minNode(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }
}
