package edu.hitsz.aircraft;

import edu.hitsz.application.Game.Game;
import edu.hitsz.basic.Observer;

/**
 * 普通敌机
 * 不可射击
 * 坠毁不生成道具
 */
public class MobEnemy extends AbstractEnemyAircraft implements Observer {
    public MobEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        propNum = 0;
    }
    public void update(){
        this.vanish();
        Game.addScore(10);
    }
}
