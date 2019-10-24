package com.future.disign_model.creator.prototype;

/**
 * @author zcd
 * @date 2019-06-03 21:59
 */

/**
 * 测试一个原型模式的使用场景
 * 在一个for循环体中，大量的创建对象，而且这个类的构造方法很复杂---》我们尝试使用原型模式
 */
public class Test
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Mail mail = new Mail();
        mail.setContext("template");
        for(int i = 0 ; i <= 10; i++)
        {
            Mail mail12 = (Mail)mail.clone();
            mail12.setContext("mapper.test" + i);
            mail12.setAddress("testaddres");
            mail12.setName("mapper.test-name"+i);
            System.out.println(mail12);
        }
    }
}
