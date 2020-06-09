package com.future.data.structure.linearStructure.linkedList;

public class MyLinkedList<E> implements ILinkedList<E> {
    private class Node {
        E e;
        Node next;

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            e = null;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    //定义一个头节点
    Node head;
    //定义一个连表大小
    int size;

    @Override
    public boolean add(E e) {
        //add new element head
        head = new Node(e, head);
        size++;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E remove(E e) {
        if (head.e.equals(e)) {
            E res = head.e;
            head = head.next;
            size--;
            return res;
        } else {
            return innerRemove(head, e);
        }
    }

    public boolean contains(E e) {
        assert e != null;
        if (head.e.equals(e)) {
            return true;
        } else {
            Node flag = head.next;
            while (flag != null) {
                if (flag.e.equals(e)) {
                    return true;
                }
                flag = flag.next;
            }
            return false;
        }
    }

    private E innerRemove(Node node, E e) {
        assert node != null;
        if (node.next != null) {
            if (node.next.e.equals(e)) {
                E res = node.next.e;
                node.next = node.next.next;
                size--;
                return res;
            } else {
                innerRemove(node.next, e);
            }
        }
        return null;
    }


    public boolean remove(int index) {
        return false;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
