package com.future.SixPrinciple.dependceinverse;

/**
 * Created by zcd on 2019-05-21
 */
public class DInverseTest
{
    public static void main(String[] args)
    {
        Student s1 = new Student();
        s1.setiCourse(new JavaCourseImpl());
        Student s2 = new Student();
        s2.setiCourse(new ScalaCouseImpl());

        s1.studyCourse();
        s2.studyCourse();
    }
}
