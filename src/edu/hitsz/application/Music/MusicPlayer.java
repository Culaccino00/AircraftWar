package edu.hitsz.application.Music;

public class MusicPlayer {
    private volatile boolean doPlay = true;
    private volatile static MusicPlayer musicPlayer;
    public static MusicPlayer getMusicPlayer(){
        if(musicPlayer == null){
            synchronized(MusicPlayer.class){
                if(musicPlayer == null){
                    musicPlayer = new MusicPlayer();
                }
            }
        }
        return musicPlayer;
    }

    public MusicThread playMusic(String filename) {
        MusicThread musicThread = null;
        if (doPlay) {
            musicThread = new MusicThread(filename);
            musicThread.setLoop(filename.equals("src/videos/bgm.wav") || filename.equals("src/videos/bgm_boss.wav"));
            musicThread.start();
        }
        return musicThread;
    }
    public void stopMusic(MusicThread musicThread){
        if(musicThread.isAlive()){
            musicThread.requestStop();
        }
    }
    public void noMusic(){
        doPlay = false;
    }
}
