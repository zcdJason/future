package com.future.disign_model.structure.decorator.v1;

/**
 * @author zcd
 * @date 2019-06-10 23:19
 */
public class BattleCakeWithEggSausage extends BattleCakeEgg
{
    @Override
    public String getDesc()
    {
        return super.getDesc() + "add sauage";
    }

    @Override
    public int cost()
    {
        return super.cost() + 1;
    }
}
