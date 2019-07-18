package com.future.disign_model.decorator.v2;

/**
 * @author zcd
 * @date 2019-06-10 23:06
 */
public class Battercacke extends ABattercake
{
    @Override
    String getDesc()
    {
        return "add a cake";
    }

    @Override
    int cost()
    {
        return 8;
    }
}
