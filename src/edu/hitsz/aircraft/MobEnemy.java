package edu.hitsz.aircraft;
/**
 * 普通敌机
 * 不可射击
 * 坠毁不生成道具
 */
public class MobEnemy extends EnemyAircraft{
    public MobEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        propNum = 0;
    }
}
