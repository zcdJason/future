package com.future.effectJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author: Cock a doodle doo
 */
public class TInter {

    boolean isEmpty() {
        return  true;
    }
    //包含一个未知类型的集合list1和list2
    void compare(List<?> list1, List<?> list2){
        for(Object o :list1){
            if(list2.contains(o)){
                return;
            }
        }
    }

    //包含一个未知类型的集合list1和list2
    <T> void  compare2(List<T> list1, List<T> list2){
        for(T o :list1){
            if(list2.contains(o)){
                return;
            }
        }
    }

    public static boolean test(String str){

        return null == str || str.length() <=0;
//        return  null == str || "".equals(str) || "null".equals(str);
    }

    public static void main(String[] args) {
        String ss = "";
        System.out.println(test(ss));
        System.out.println(String.class);
        System.out.println(List.class);
    }
}
