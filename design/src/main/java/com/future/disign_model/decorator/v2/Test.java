package com.future.disign_model.decorator.v2;

/**
 * @author zcd
 * @date 2019-06-10 23:03
 */
public class Test
{
    public static void main(String[] args)
    {
        ABattercake aBattercake;
        aBattercake = new Battercacke();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SuggerDecorator(aBattercake);
        System.out.println(aBattercake.getDesc() + "cose: " + aBattercake.cost());
    }
}
