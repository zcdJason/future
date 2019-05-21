package com.future.SixPrinciple.opencolse;

/**
 * open-close design principle
 * 开闭原则，课程接口
 * 开闭原则：对扩展开放，对修改关闭
 * 1-抽象公共的部分定义接口/抽象类，这样的结构稳定（一般我们不会去时常修改接口）
 * 2-具体类去实现接口，如果这个类具有自己特有的行为，那么对其扩展，而不是修改其原有的逻辑
 *
 * @author: zcd
 * @date: 2019/3/1 15:37
 */
public interface ICourse
{
    /**
     * 获取课程名称
     *
     * @return
     */
    String getCourseName();

    /**
     * 获取课程Id
     *
     * @return
     */
    Integer getCourseId();

    /**
     * 获取课程价格
     *
     * @return
     */
    Double getCoursePrice();
}
