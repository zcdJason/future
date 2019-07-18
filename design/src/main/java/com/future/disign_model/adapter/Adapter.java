package com.future.disign_model.adapter;

/**
 * @author zcd
 * @date 2019-06-10 23:56
 */
public class Adapter implements Dc5v
{
    private AC220 ac220 = new AC220();

    @Override
    public int outPutDC()
    {
        int inpustAC = ac220.getAC220();
        System.out.println("adaptor " + inpustAC / 44);
        return inpustAC / 44;
    }
}
