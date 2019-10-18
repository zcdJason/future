package com.future.callback;

/**
 * @author zcd
 * @date 2019-09-06 12:57
 */
public class TestMain
{
    public static void main(String[] args)
    {
        Teacher t1 = new Teacher();
        Student t2 = new Student();
        t1.ask(t2);
    }
}
