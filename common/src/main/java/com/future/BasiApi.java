package com.future;

/**
 * @author Cock-a-doodle-doo!
 */
public interface BasiApi {
    void test();

    default void uid(){
        System.out.println("hello");
    }

    default String rs(){
        return "add";
    }

    static String dis(){
        return "static dis";
    }
}
