package com.future.opencolse;

/**
 * java 课程继承ICourse 接口
 *
 * @author: zcd
 * @date: 2019/3/1 15:40
 */
public class JavaCourse implements ICourse {
    private Integer courseId;
    private String courseName;
    private Double coursePrice;

    public JavaCourse(Integer courseId, String courseName, Double coursePrice) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
    }

    @Override
    public String getCourseName() {
        return this.courseName;
    }

    @Override
    public Integer getCourseId() {
        return this.courseId;
    }

    @Override
    public Double getCoursePrice() {
        return this.coursePrice;
    }
}
