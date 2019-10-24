package com.future.disign_model.structure.decorator.v2;

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

    /**
     * 半透明模式，增加了方法（和父类提供的方法对比）
     */
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
