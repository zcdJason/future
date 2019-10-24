package com.future.disign_model.structure.decorator.v2;

/**
 * @author zcd
 * @date 2019-06-10 23:30
 */
public class SuggerDecorator extends AbstractDecorator
{

    public SuggerDecorator(ABattercake aBattercake)
    {
        super(aBattercake);
    }

    @Override
    public void doSomething()
    {
        /*
          不同的装饰者有不同的处理方法，上层抽象了一个方法
         */
    }

    @Override
    String getDesc()
    {
        return super.getDesc() + " add a sugger";
    }

    @Override
    int cost()
    {
        return super.cost() + 1;
    }
}
