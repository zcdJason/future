package com.future.base;

import com.alibaba.fastjson.serializer.AppendableSerializer;
import com.future.thinkInJava5.onjava.Nap;
import com.future.thinkInJava5.onjava.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Cock-a-doodle-doo!
 */
public class BaseFuture {



    public static  void doSomethingElse(double timeout){
        new Nap(timeout);
        System.out.println("其它事情做完了。。。。。");
    }

    public static double doSomethingComputer(double input){
        new Nap(input);
        System.out.println("计算完成了。。。。。。");
        return input;
    }

    public static void test(){

    }


    //? extends Number 在方法中只能提前元素进行操作

//    static void addPerson(Person<? extends Number> person){
//        System.out.println(person.getFirst());
//
//        person.setFirst(5);
//        System.out.println(person.getFirst());
//    }


    public static void main(String[] args) {
//        Person<Integer> person = new Person<>();
//        addPerson(person);


//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        Future<Double> res = singleThreadExecutor.submit(() -> {
//            return doSomethingComputer(10); //计算
//        });
//        doSomethingElse(2); //做其它事情
//        try {
//            res.get(5, TimeUnit.SECONDS);
//        } catch (InterruptedException | ExecutionException | TimeoutException e) {
//            e.printStackTrace();
//        }
//        singleThreadExecutor.shutdown();
    }
}
