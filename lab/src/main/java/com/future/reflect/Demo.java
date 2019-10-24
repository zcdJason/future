package com.future.reflect;


public class Demo<T> {
    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", t=" + t +
                '}';
    }

    private String name;
    private String age;

    private T t;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
