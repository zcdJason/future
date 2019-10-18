package com.future.proxy;

import java.io.Serializable;

/**
 * @author zcd
 * @date 2019-06-11 10:17
 */
public class Test implements Serializable
{
    private static final long serialVersionUID = 6456846441130293617L;

    public static void main(String[] args)
    {
        AProxy aProxy = new AProxy();
        aProxy.sailTicket(10);
    }
}
