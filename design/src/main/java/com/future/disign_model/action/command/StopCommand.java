package com.future.disign_model.action.command;

/**
 * @author zcd
 * @date 2019-06-11 19:53
 */
public class StopCommand implements Command
{
    private AudioPlayer audioPlayer;

    public StopCommand(AudioPlayer audioPlayer)
    {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute()
    {
        audioPlayer.stop();
    }
}
