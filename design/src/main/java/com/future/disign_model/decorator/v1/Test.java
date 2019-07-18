package com.future.disign_model.decorator.v1;

/**
 * @author zcd
 * @date 2019-06-10 23:20
 */
public class Test
{
    public static void main(String[] args)
    {
        BattleCake b1 = new BattleCake();
        System.out.println(b1.getDesc() + "cost " + b1.cost());

        BattleCake b2 = new BattleCakeEgg();
        System.out.println(b2.getDesc() + "cost " + b2.cost());

        BattleCake b3 = new BattleCakeWithEggSausage();
        System.out.println(b3.getDesc() + "cost " + b3.cost());
    }
}
