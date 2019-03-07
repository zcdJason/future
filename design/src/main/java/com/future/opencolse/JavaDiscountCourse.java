package com.future.opencolse;

/**
 * @author: zcd
 * @date: 2019/3/1 15:45
 */
public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer courseId, String courseName, Double coursePrice) {
        super(courseId, courseName, coursePrice);
    }

    @Override
    public Double getCoursePrice() {
        return super.getCoursePrice() * 0.8;
    }

    public Double getOriginPrice(){
        return super.getCoursePrice();
    }
}
