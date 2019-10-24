package com.future.disign_model.action.command;

/**
 * @author zcd
 * @date 2019-06-11 19:54
 */
public class RewindCommand implements Command
{
    private AudioPlayer audioPlayer;

    public RewindCommand(AudioPlayer audioPlayer)
    {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute()
    {
        audioPlayer.rewind();
    }
}
