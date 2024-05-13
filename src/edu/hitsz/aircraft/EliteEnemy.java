package edu.hitsz.aircraft;

/**
 * 精英敌机
 * 直射子弹
 * 坠毁生成1个道具
 */
public class EliteEnemy extends EnemyAircraft {
    public EliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        propNum = 1;
    }
}
