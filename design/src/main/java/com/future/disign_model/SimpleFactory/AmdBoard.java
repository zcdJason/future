package com.future.disign_model.SimpleFactory;

/**
 * Created by zcd on 2019-05-21
 */
public class AmdBoard implements Board
{
    private int blot;

    public AmdBoard(int blot){
        this.blot = blot;
    }

    public String getBoardType()
    {
        return "amd";
    }

    @Override
    public void installCpu()
    {
        System.out.println("install amd cpu, points = " + blot);
    }
}
