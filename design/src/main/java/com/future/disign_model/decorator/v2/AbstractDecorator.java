package com.future.disign_model.decorator.v2;

/**
 * @author zcd
 * @date 2019-06-10 23:24
 */
public abstract class AbstractDecorator extends ABattercake
{
    private ABattercake aBattercake;

    public AbstractDecorator(ABattercake aBattercake)
    {
        this.aBattercake = aBattercake;
    }

    public abstract void doSomething();

    @Override
    String getDesc()
    {
        return this.aBattercake.getDesc();
    }

    @Override
    int cost()
    {
        return this.aBattercake.cost();
    }
}
