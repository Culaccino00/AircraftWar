package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.application.Music.MusicPlayer;
import edu.hitsz.application.Music.MusicThread;
import edu.hitsz.basic.Observer;
import edu.hitsz.bullet.BaseBullet;

import java.util.ArrayList;
import java.util.List;

public class BombProp extends BaseProp {
    public BombProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }
    //观察者列表
    private List<Observer> observerList = new ArrayList<>();

    //添加观察者
    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    //删除观察者
    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    //通知所有观察者
    public void notifyAllFlyings(){
        for(Observer observer : observerList){
            observer.update();
        }
    }

    //效果
    @Override
    public void effect(AbstractAircraft aircraft){
        MusicPlayer.getMusicPlayer().playMusic("src/videos/bomb_explosion.wav");
        System.out.println("BombSupply active!");
        notifyAllFlyings();
        vanish();
    }
}
