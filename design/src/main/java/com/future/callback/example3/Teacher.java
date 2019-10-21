package com.future.callback.example3;

public class Teacher {
    public void publishJob(String job, Student student)
    {
        System.out.println("teacher: publish a job -> " + job);
        student.doWork(job);
    }
}
