package edu.hitsz.aircraft;

import edu.hitsz.application.Game.Game;
import edu.hitsz.basic.Observer;

/**
 * 超级精英敌机
 * 散射子弹
 * 坠毁生成1个道具
 */
public class ElitePlusAbstractEnemy extends AbstractEnemyAircraft implements Observer {
    public ElitePlusAbstractEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        propNum = 1;
    }
    public void update(){
        this.decreaseHp(20);
        if(this.notValid()){
            Game.addScore(10);
        }
    }
}
