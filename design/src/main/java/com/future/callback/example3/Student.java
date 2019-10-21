package com.future.callback.example3;

import javafx.concurrent.Worker;

public class Student implements WorkCallBack {

    public void doWork(String job)
    {
        System.out.println("Student: I get job ->" + job);
        if(job.equals("1+1"))
        {
            System.out.println("Student: answer -> " + 2);
        }else{
            System.out.println("Student: I dont't know!, I pay money 5$ to SuperStudent, please help");
            SuperStudent superStudent = new SuperStudent();
            superStudent.doWork(job, this);
        }
    }

    @Override
    public void callBack(String answer) {
        System.out.println("Student: get answer -> " + answer);
    }
}
