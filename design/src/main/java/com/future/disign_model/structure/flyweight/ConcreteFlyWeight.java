package com.future.disign_model.structure.flyweight;

/**
 * @author zcd
 * @date 2019-06-11 09:50
 */
public class ConcreteFlyWeight implements FlyWeight
{
    private String insideStats;

    @Override
    public void operation(String state)
    {
        this.insideStats = state;
    }

    public ConcreteFlyWeight(String insideStats)
    {
        this.insideStats = insideStats;
    }
}
