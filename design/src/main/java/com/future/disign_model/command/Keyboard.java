package com.future.disign_model.command;

/**
 * @author zcd
 * @date 2019-06-11 19:56
 */
public class Keyboard
{
    private PlayCommand playCommand;
    private RewindCommand rewindCommand;
    private StopCommand stopCommand;

    public void play()
    {
        playCommand.execute();
    }

    public  void rewind()
    {
        rewindCommand.execute();
    }

    public void  stop()
    {
        stopCommand.execute();
    }
    public PlayCommand getPlayCommand()
    {
        return playCommand;
    }

    public void setPlayCommand(PlayCommand playCommand)
    {
        this.playCommand = playCommand;
    }

    public RewindCommand getRewindCommand()
    {
        return rewindCommand;
    }

    public void setRewindCommand(RewindCommand rewindCommand)
    {
        this.rewindCommand = rewindCommand;
    }

    public StopCommand getStopCommand()
    {
        return stopCommand;
    }

    public void setStopCommand(StopCommand stopCommand)
    {
        this.stopCommand = stopCommand;
    }
}
