package edu.hitsz.aircraft;

import edu.hitsz.application.Game.Game;
import edu.hitsz.basic.Observer;

/**
 * 精英敌机
 * 直射子弹
 * 坠毁生成1个道具
 */
public class EliteAbstractEnemy extends AbstractEnemyAircraft implements Observer {
    public EliteAbstractEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        propNum = 1;
    }
    public void update(){
        this.vanish();
        Game.addScore(10);
    }
}
