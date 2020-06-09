package com.future.data.structure.linearStructure.linkedList;

public class MyDummyList<E> implements ILinkedList<E>{
    private int size;
    private Node dummyHead;
    private Node first;
    private Node last;

    public  MyDummyList(){
        dummyHead = new Node();
        first = dummyHead;
        last = dummyHead;
        size = 0;
    }

    @Override
    public boolean add(E e) {
        return addLast(e);
    }

    private boolean add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("add failed, illegal index");
        Node prev = dummyHead;
        for(int i=0; i< index; i++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size ++;
        return true;
    }

    public boolean contains(E e){
        Node current = dummyHead.next;
        while ((current != null))
        {
            if(current.e.equals(e))
                return  true;
            current = current.next;
        }
        return false;
    }

    //add
    public boolean addLast(E e){
        last  = new Node(e, null);
        add(size, e);
        return true;
    }

    public boolean addFirst(E e){
        first  = new Node(e, null);
        add(0, e);
        return true;
    }

    public E getFirst(){
        return dummyHead.next.e;
    }

    public E getLast(){
        return last.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public E remove(E e) {
        Node prev = dummyHead;
        while ((prev.next != null))
        {
            Node current = prev.next;
            if(current.e.equals(e)){
                prev.next = current.next;
                if(e.equals(last.e)){
                    last = prev;
                }
                size --;
                return e;
            }
            prev = prev.next;
        }
        return null;
    }

    private class Node{
        E e;
        Node next;
        public Node(){
            this.e = null;
            this.next = null;
        }
        public Node(E e){
            this.e = e;
            this.next = null;
        }
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyDummyList{" +
                "size=" + size +
                ", dummyHead=" + dummyHead +
                ", first=" + first +
                ", last=" + last +
                '}';
    }
}
