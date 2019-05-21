package com.future.SixPrinciple.LSP;

/**
 * Created by zcd on 2019-05-21
 *
 * 子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。
 * Liskov Substitution Principle LSP
 *
 * 子类对父类的方法尽量不要重写和重载。因为父类代表了定义好的结构，通过这个规范的接口与外界交互，子类不应该随便破坏它。
 */
public abstract class Animal
{
    private String runSpeed;

    public String getRunSpeed()
    {
        return runSpeed;
    }

    public void setRunSpeed(String runSpeed)
    {
        this.runSpeed = runSpeed;
    }
}
