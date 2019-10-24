package com.future.disign_model.structure.decorator.v1;

/**
 * @author zcd
 * @date 2019-06-10 23:17
 */
public class BattleCakeEgg extends BattleCake
{
    @Override
    public String getDesc()
    {
        return super.getDesc() + "add a agg";
    }

    @Override
    public int cost()
    {
        return super.cost() + 1;
    }
}
