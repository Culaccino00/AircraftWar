package edu.hitsz.aircraft;

/**
 * 超级精英敌机
 * 散射子弹
 * 坠毁生成1个道具
 */
public class ElitePlusEnemy extends EnemyAircraft{
    public ElitePlusEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        propNum = 1;
    }
}
