package com.future.disign_model.command;

/**
 * @author zcd
 * @date 2019-06-11 19:51
 */
public class PlayCommand implements Command
{
    private AudioPlayer audioPlayer;

    public PlayCommand(AudioPlayer audioPlayer)
    {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute()
    {
        audioPlayer.play();
    }
}
