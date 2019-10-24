package com.future.disign_model.creator.SimpleFactory;

/**
 * Created by zcd on 2019-05-21
 */
public class InterBoard implements Board
{
    private int blot;

    public InterBoard(int blot)
    {
        this.blot = blot;
    }

    public String getBoardType()
    {
        return "inter";
    }

    @Override
    public void installCpu()
    {
        System.out.println("inter board install inter cpu, blot = " + blot);
    }
}
