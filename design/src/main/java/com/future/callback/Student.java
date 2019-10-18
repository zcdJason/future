package com.future.callback;

/**
 * @author zcd
 * @date 2019-09-06 12:47
 */
public class Student
{
    public void answer(){

    }

    /**
     * 学生回到老师问题的实现
     * @param person
     */
    public void answer(Teacher person){
        System.out.println("student cannot answer");
        person.explainQuestion();
        System.out.println("teacher help me,slove question");
    }
}
