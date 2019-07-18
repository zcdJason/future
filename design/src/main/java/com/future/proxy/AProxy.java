package com.future.proxy;

/**
 * @author zcd
 * @date 2019-06-11 10:12
 */
public class AProxy implements Train
{
    private ChengduTrain chengduTrain = new ChengduTrain();
    @Override
    public int sailTicket(int i)
    {
        return chengduTrain.sailTicket(i);
    }
}
