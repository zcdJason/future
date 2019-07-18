package com.future.proxy;

/**
 * @author zcd
 * @date 2019-06-11 10:14
 */
public class ChengduTrain implements Train
{
    @Override
    public int sailTicket(int i)
    {
        System.out.println("sell ticket i:" + i);
        return i;
    }
}
