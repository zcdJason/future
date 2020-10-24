package com.future.disign_model.creator.prototype;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @author zcd
 * @date 2019-06-03 22:21
 */
public class TestDeepClone
{
    /**
     * 假设原型模式的克隆对象中有引用类型，浅克隆（模式的clone方式）引用类型引用的是同一个对象
     * 这个时候为类实现克隆的时候其引用不同的对象时候，需要深克隆
     */
    public static void main(String[] args) throws CloneNotSupportedException
    {
        MailDeep mailDeep = new MailDeep();
        mailDeep.setAge(1);
        mailDeep.setName("test1");
        mailDeep.setBirthday(new Date(0));

        MailDeep copyMail = (MailDeep)mailDeep.clone();
        System.out.println(mailDeep);
        System.out.println(copyMail);

        copyMail.setAge(2);
        /**
         * 如果实现Date的深克隆，那么copy对象的修改会同时影响原来对象的值（引用的是同一对象）
         */
        copyMail.getBirthday().setTime(6666666666666L);
        System.out.println(mailDeep);
        System.out.println(copyMail);
    }
}
