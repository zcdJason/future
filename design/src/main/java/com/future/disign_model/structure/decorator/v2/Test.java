package com.future.disign_model.structure.decorator.v2;

/**
 * @author zcd
 * @date 2019-06-10 23:03
 */
public class Test
{
    public static void main(String[] args)
    {
        /**
         * 装饰器组装
         */
        ABattercake aBattercake = new SuggerDecorator(new EggDecorator(new Battercacke()));
        System.out.println(aBattercake.getDesc() + "cose: " + aBattercake.cost());
    }
}
