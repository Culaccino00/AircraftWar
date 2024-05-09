package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.application.Music.MusicPlayer;
import edu.hitsz.application.Music.MusicThread;
import edu.hitsz.bullet.BaseBullet;

public class BombProp extends BaseProp {
    public BombProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }
    @Override
    public void effect(AbstractAircraft aircraft){
        MusicPlayer.getMusicPlayer().playMusic("src/videos/bomb_explosion.wav");
//        System.out.println("BombSupply active!");
        vanish();
    }
}
