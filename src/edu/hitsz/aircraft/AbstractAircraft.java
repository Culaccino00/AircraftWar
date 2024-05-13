package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.prop.BaseProp;
import edu.hitsz.strategy.ShootStrategy;

import java.util.List;

/**
 * 所有种类飞机的抽象父类：
 * 敌机（BOSS, ELITE, MOB），英雄飞机
 *
 * @author hitsz
 */
public abstract class AbstractAircraft extends AbstractFlyingObject {
    /**
     * 生命值
     */
    protected int maxHp;
    protected int hp;

    /**
     * 射击策略
     */
    private ShootStrategy shootStrategy;

    public AbstractAircraft(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY);
        this.hp = hp;
        this.maxHp = hp;
    }

    /**
     * 设置射击策略
     * @param shootStrategy
     */
    public void setStrategy(ShootStrategy shootStrategy) {
        this.shootStrategy = shootStrategy;
    }

    /**
     * 获取射击策略
     * @return
     */
    public ShootStrategy getStrategy(){
        return this.shootStrategy;
    }

    /**
     * 射击方法
     * @param locationX
     * @param locationY
     * @param speedX
     * @param speedY
     * @param direction
     * @return
     */
    public List<BaseBullet> doShoot(int locationX, int locationY, int speedX, int speedY, int direction){
        return shootStrategy.shootBullet(locationX, locationY, speedX, speedY, direction);
    }

    /**
     * 减少生命值
     * @param decrease
     */
    public void decreaseHp(int decrease){
        hp -= decrease;
        if(hp <= 0){
            hp=0;
            vanish();
        }
    }

    /**
     * 获取生命值
     * @return
     */
    public int getHp() {
        return hp;
    }

    /**
     * 获取最大生命值
     * @return
     */
    public int getMaxHp(){return maxHp;}

    /**
     * 飞机射击方法，可射击对象必须实现
     * @return
     *  可射击对象需实现，返回子弹
     *  非可射击对象空实现，返回null
     */
    public abstract List<BaseBullet> shoot();

    /**
     * 创建道具
     * @return
     *  可生成道具的对象需实现，返回道具
     *  不可生成道具的对象空实现，返回null
     */
    public abstract List<BaseProp> createProps();
}


