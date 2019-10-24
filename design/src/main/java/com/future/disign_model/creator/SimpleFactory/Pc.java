package com.future.disign_model.creator.SimpleFactory;

/**
 * Created by zcd on 2019-05-21
 */
public class Pc
{
    private  Cpu cpu;
    private Board board;

    public Cpu getCpu()
    {
        return cpu;
    }

    public void setCpu(Cpu cpu)
    {
        this.cpu = cpu;
    }

    public Board getBoard()
    {
        return board;
    }

    public void setBoard(Board board)
    {
        this.board = board;
    }
}
