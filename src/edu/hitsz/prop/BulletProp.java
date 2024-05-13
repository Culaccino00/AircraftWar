package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.application.Music.MusicPlayer;
import edu.hitsz.application.Music.MusicThread;
import edu.hitsz.strategy.ScatterShootStrategy;
import edu.hitsz.strategy.StraightShootStrategy;

public class BulletProp extends BaseProp{
    public BulletProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }
    @Override
    public void effect(AbstractAircraft aircraft){
        MusicPlayer.getMusicPlayer().playMusic("src/videos/get_supply.wav");
        Runnable r = ()->{
            ScatterShootStrategy scatterShootStrategy = new ScatterShootStrategy();
            aircraft.setStrategy(scatterShootStrategy);
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(aircraft.getStrategy() == scatterShootStrategy){
                aircraft.setStrategy(new StraightShootStrategy());
            }
        };
        new Thread(r).start();
        System.out.println("FireSupply active!");
        vanish();
    }
}
