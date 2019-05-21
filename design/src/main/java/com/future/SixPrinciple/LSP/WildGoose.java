package com.future.SixPrinciple.LSP;

/**
 * Created by zcd on 2019-05-21
 */
public class WildGoose extends Bird
{
    /**
     * 大雁具有鸟和动物的特性，因此可以飞和跑
     *
     * 大雁有自己的特征，如人字形✈️
     */
    private   String personFly;

    public String getPersonFly()
    {
        return personFly;
    }

    public void setPersonFly(String personFly)
    {
        this.personFly = personFly;
    }
}
