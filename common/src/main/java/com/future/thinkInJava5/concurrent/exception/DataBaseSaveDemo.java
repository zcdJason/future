package com.future.thinkInJava5.concurrent.exception;

import static java.lang.Thread.sleep;

import com.future.utils.JsonUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.w3c.dom.ls.LSOutput;

class ExpTest{

    String test(String s){
        return s.toUpperCase();
    }

}
/**
 * @author Cock-a-doodle-doo!
 */
public class DataBaseSaveDemo {

    static class SaveSource {

        static boolean saveData(int timeout) {
            if (timeout > 5) {
                throw new RuntimeException("存放数据源超时错误");
            } else {
                System.out.println("存放数据源成功");
                return true;
            }
        }

        static boolean delData(int timeout) {
            if (timeout > 5) {
                throw new RuntimeException("删除数据源超时错误");
            } else {
                System.out.println("删除数据源成功");
                return true;
            }
        }

        static boolean saveDictData(int timeout) {
            if (timeout > 5) {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("存放数据字典信息超时错误");
            } else {
                System.out.println("存放字典信息成功");
                return true;
            }
        }
    }

    @FunctionalInterface
    interface Test{
        //抽象方法的签名就是lambda表达式的签名我们称它为-----函数描述符
        void get(
        );

    }


    public static void main(String[] args) {
System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");

//
//        Stream.generate(Math :: random)
//            .limit(10)
//            .forEach(System.out::println);

//        IntStream.of(1, 10).forEach(System.out::println);
//        IntStream.range(1, 10);
//        LongStream.range(1, 10);
//        IntStream.rangeClosed(1, 10);
//
//
//        int[] aa = {1,2,3};
//        Arrays.stream(aa);
//
//        Predicate<String>  ps = s -> s.length() > 0;
//
//        Supplier<String> sr = String::new;
//        String s = sr.get();
//        System.out.println(s);

//        函数式接口：只有一个抽象方法的接口（如果有很多个默认实现也没有关系，它仍然是函数式接口）
        //理解到 "只有一个" 抽象函数/方法的接口


//
//        List<String> ss = Arrays.asList("hello", "tiger");
//        ss.stream().forEach(System.out::println);
//
//
//
//        ss.sort(String::compareToIgnoreCase);

//        List<String> collect = Stream.of("hello", "tiger").collect(Collectors.toList());

//        System.out.println(UUID.nameUUIDFromBytes(("mysql").getBytes()).toString());
//        System.out.println(UUID.nameUUIDFromBytes(("demo").getBytes()).toString());
//        CompletableFuture<Boolean> res = CompletableFuture.supplyAsync(() -> SaveSource.saveData(5))
//            .thenApply(flag -> {
//                if (flag) {
//                    return SaveSource.saveDictData(99);
//                } else {
//                    return false;
//                }
//            }).exceptionally(e -> {
//            if (e != null) {
//                //处理异常
//                System.out.println(e);
//                System.out.println("回滚数据---------------");
//                SaveSource.delData(3);
//            }
//            return false;
//        });
//        res.join();

//        CompletableFuture<Boolean> res = CompletableFuture.supplyAsync(()-> SaveSource.saveData(3))
//            .exceptionally(e -> {
//                if(e != null)
//                {
//                    //处理异常
//                    System.out.println(e);
//                }
//                return  false;
//            });
//
//        CompletableFuture<Boolean> res2 = CompletableFuture.supplyAsync(()-> SaveSource.saveDictData(99))
//            .exceptionally(e -> {
//                if(e != null)
//                {
//                    //处理异常
//                    System.out.println(e);
//                }
//                return  false;
//            });
//
//        CompletableFuture.allOf(res, res2).join();
    }
}
