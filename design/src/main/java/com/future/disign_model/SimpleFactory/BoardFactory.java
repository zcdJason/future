package com.future.disign_model.SimpleFactory;

/**
 * Created by zcd on 2019-05-21
 */
public class BoardFactory
{
    /**
     * make board
     */
    public Board builder(PcType pcType)
    {
        Board board = null;
        if (pcType == PcType.amd)
        {
            board = new AmdBoard(755);
        } else if (pcType == PcType.inter)
        {
            board = new InterBoard(933);
        }

        return board;
    }
}
