package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.application.Music.MusicPlayer;
import edu.hitsz.application.Music.MusicThread;
import edu.hitsz.strategy.RingShootStrategy;
import edu.hitsz.strategy.ScatterShootStrategy;
import edu.hitsz.strategy.ShootStrategy;
import edu.hitsz.strategy.StraightShootStrategy;

public class BulletPlusProp  extends BaseProp{
    public BulletPlusProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }
    @Override
    public void effect(AbstractAircraft aircraft){
        MusicPlayer.getMusicPlayer().playMusic("src/videos/get_supply.wav");
        Runnable r = ()->{
            RingShootStrategy ringShootStrategy = new RingShootStrategy();
            aircraft.setStrategy(ringShootStrategy);
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(aircraft.getStrategy() == ringShootStrategy){
                aircraft.setStrategy(new StraightShootStrategy());
            }
        };
        new Thread(r).start();
        System.out.println("FireSupplyPro active!");
        vanish();
    }
}
