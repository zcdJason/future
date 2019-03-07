package com.future.dependceinverse;

/**
 * 学生类提供一个学习课程的方法，接受课程接口参数
 *
 * @author: zcd
 * @date: 2019/3/1 16:41
 */
public class Student {
    private ICourse iCourse;

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void studyCourse(){
        iCourse.studyCourse();
    }
}
