package com.future.opencolse;

/**
 * open-close design principle
 *  开闭原则，课程接口
 * @author: zcd
 * @date: 2019/3/1 15:37
 */
public interface ICourse {
    /**
     * 获取课程名称
     * @return
     */
    String getCourseName();

    /**
     * 获取课程Id
     * @return
     */
    Integer getCourseId();

    /**
     * 获取课程价格
     * @return
     */
    Double getCoursePrice();
}
