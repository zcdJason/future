package com.future.SixPrinciple.dependceinverse;

/**
 * 学生类提供一个学习课程的方法，接受课程接口参数
 *
 * @author: zcd
 * @date: 2019/3/1 16:41
 *
 * 学生依赖课程接口，具体学什么就传递什么样的课程
 * 高层只依赖接口，而不依赖具体的实现；高层和具体实现的解偶
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
