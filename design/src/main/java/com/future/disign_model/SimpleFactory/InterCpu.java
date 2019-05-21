package com.future.disign_model.SimpleFactory;

/**
 * Created by zcd on 2019-05-21
 */
public class InterCpu implements Cpu
{
    @Override
    public String getCpuType()
    {
        return "inter";
    }

    @Override
    public void cal()
    {
        System.out.println("Inter cpu cal");
    }
}
