package com.future.data.structure.linearStructure.linkedList;

public class StackLinkedList<E> {
    private MyDummyList<E> data;
    public StackLinkedList(){
        data = new MyDummyList();
    }

    public boolean push(E e){
        return  data.add(e);
    }

    public E pop(){
        return  data.remove(data.getLast());
    }

    public  E peek(){
        return  data.getLast();
    }

    @Override
    public String toString() {
        return "StackLinkedList{" +
                "data=" + data +
                '}';
    }
}
