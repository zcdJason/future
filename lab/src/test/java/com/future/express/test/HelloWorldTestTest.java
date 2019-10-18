package com.future.express.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zcd on 2019-05-23
 */
class HelloWorldTestTest
{
    @Test
    public void test()
    {
        List<String> test = new ArrayList<>();
        test.add("test");
        test.add("tiger");
        System.out.println(test.remove(0));
    }

}