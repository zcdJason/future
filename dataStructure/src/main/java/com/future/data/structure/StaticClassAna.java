package com.future.data.structure;

/**
 * @author: Cock a doodle doo
 */
public class StaticClassAna {
    static abstract class Human{ }
    static class Man extends Human{}
    static class Woman extends Human{}

    public void syHello(Human human){
        System.out.println("human hello");
    }

    public void syHello(Man man){
        System.out.println("man hello");
    }

    public void syHello(Woman woman){
        System.out.println("Woman hello");
    }

    public static void main(String[] args) {
        Human m = new Man();
        Human w = new Woman();
        StaticClassAna sa = new StaticClassAna();
        sa.syHello(m);
        sa.syHello(w);
    }
}
