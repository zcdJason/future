package com.future.SixPrinciple.dependceinverse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: zcd
 * @date: 2019/3/1 16:45
 */
public class StudentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void studyCourse() {
        /**
         * 依赖倒置的原则
         * 针对接口编程
         * 应用层不依赖 Student的具体实现；他们都依赖抽象
         */
        //构建一个新学生 zcd
        Student  zcd = new Student();

        //zcd 想学习java 课程
        ICourse java = new JavaCourseImpl();
        zcd.setiCourse(java);
        zcd.studyCourse();

        //zcd 想学习scala 课程
        ICourse scala = new ScalaCouseImpl();
        zcd.setiCourse(scala);
        zcd.studyCourse();
    }
}