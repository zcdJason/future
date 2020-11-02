package com.future.base;

/**
 * @author Cock-a-doodle-doo!
 */
public class Person<T> {
    private T first;
    private T last;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }
}
