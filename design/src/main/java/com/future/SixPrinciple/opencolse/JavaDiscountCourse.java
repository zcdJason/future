package com.future.SixPrinciple.opencolse;

/**
 * @author: zcd
 * @date: 2019/3/1 15:45
 * 打折需求是一个变化，因此满足开闭原则，我们扩展JavaCourse，而不是修改其内部逻辑
 */
public class JavaDiscountCourse extends JavaCourse
{
    public JavaDiscountCourse(Integer courseId, String courseName, Double coursePrice)
    {
        super(courseId, courseName, coursePrice);
    }

    @Override
    public Double getCoursePrice()
    {
        return super.getCoursePrice() * 0.8;
    }

    public Double getOriginPrice()
    {
        return super.getCoursePrice();
    }
}
