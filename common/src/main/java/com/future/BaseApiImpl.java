package com.future;

import java.util.stream.Collectors;

/**
 * @author Cock-a-doodle-doo!
 */
public class BaseApiImpl implements BasiApi{

    @Override
    public void test() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        BaseApiImpl baseApi = new BaseApiImpl();
        baseApi.uid();
        System.out.println(BasiApi.dis());
    }
}
