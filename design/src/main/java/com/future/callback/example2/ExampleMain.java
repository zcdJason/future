package com.future.callback.example2;

public class ExampleMain {
    public static void main(String[] args) {
        Student student  = new Student();
        student.doHomeWork("1+1");

        Worker worker = new Worker();
        worker.doHomeWork("1+1");
    }
}
