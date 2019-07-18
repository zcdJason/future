package com.future.disign_model.decorator.v2;

/**
 * @author zcd
 * @date 2019-06-10 23:29
 */
public class EggDecorator extends AbstractDecorator
{
    public EggDecorator(ABattercake aBattercake)
    {
        super(aBattercake);
    }

    @Override
    public void doSomething()
    {

    }

    @Override
    String getDesc()
    {
        return super.getDesc() + "add egg";
    }

    @Override
    int cost()
    {
        return super.cost() + 1;
    }
}
