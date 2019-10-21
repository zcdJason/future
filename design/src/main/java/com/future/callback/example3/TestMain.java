package com.future.callback.example3;

import java.rmi.StubNotFoundException;

public class TestMain {
    public static void main(String[] args) {
        /**
         * 老师布置作业
         * 学生完成作业
         * 学霸搞了一个计算作业的业务，帮助那些不能完成的作业的学生做作业
         * 学霸搞了扩展业务，只要是计算的任务他都会
         *
         * 客户希望学霸将计算都好都任务放到对应都地方，这样不用麻烦自己去处理了；
         * 学霸提供了一个回调函数，只要实现了该回调函数都客户，告诉它放到什么地方即可。
         */
        Teacher teacher = new Teacher();
        Student student = new Student();
        teacher.publishJob("1+2", student);

        Ant ant = new Ant();
        ant.doWork("炒股");
    }
}
