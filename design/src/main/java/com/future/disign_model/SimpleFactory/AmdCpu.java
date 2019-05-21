package com.future.disign_model.SimpleFactory;

/**
 * Created by zcd on 2019-05-21
 */
public class AmdCpu implements Cpu
{
    @Override
    public String getCpuType()
    {
        return "amd";
    }

    @Override
    public void cal()
    {
        System.out.println("amd cpu cal");
    }
}
