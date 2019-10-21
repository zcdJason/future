package com.future.callback.example3;

public class Ant implements WorkCallBack {

    public void doWork(String job)
    {
            System.out.println("Ant: job->" + job);
            SuperStudent superStudent = new SuperStudent();
            superStudent.doWork(job, this);
    }

    @Override
    public void callBack(String answer) {
        System.out.println("Ant: get answer -> " + answer);
    }
}
