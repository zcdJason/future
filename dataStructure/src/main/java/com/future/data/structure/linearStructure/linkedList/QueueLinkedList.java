package com.future.data.structure.linearStructure.linkedList;

public class QueueLinkedList<E> {
    private  MyDummyList<E> data;
    public QueueLinkedList(){
        data = new MyDummyList();
    }

    public boolean enqueue(E e){
        return  data.add(e);
    }

    public E dequeue(){
        return data.remove(data.getFirst());
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    @Override
    public String toString() {
        return "QueueLinkedList{" +
                "data=" + data +
                '}';
    }
}
