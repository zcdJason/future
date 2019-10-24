package com.future.reflect;


public class DemoEntity  {
    public DemoEntity(String name, String age, String t) {
        this.name = name;
        this.age = age;
        this.t = t;
    }

    private String name;
    private String age;

    private String t;

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

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
}
