package com.future.SixPrinciple.dependceinverse;

/**
 * @author: zcd
 * @date: 2019/3/1 16:37
 *
 * Dependence Inversion Principle
 *
 * 面向接口编程，依赖于抽象而不依赖于具体。写代码时用到具体类时，不与具体类交互，而与具体类的上层接口交互。
 */
public interface ICourse {
    /**
     * 课程接口，提供一个学习课程的方法
     */
    void studyCourse();
}
