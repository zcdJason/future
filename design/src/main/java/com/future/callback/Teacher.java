package com.future.callback;

/**
 * @author zcd
 * @date 2019-09-06 12:51
 */
public class Teacher implements AskQuestion
{

    /**
     *  老师问问题
     * @param student
     */
    @Override
    public void ask(Student student)
    {
        student.answer(this);
    }

    /**
     * 老师解答问题
     */
    public void explainQuestion()
    {
        System.out.println("teacher explain question!");
    }
}
