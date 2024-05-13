package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.factory.*;
import edu.hitsz.prop.BaseProp;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class EnemyAircraft extends AbstractAircraft{
    /**
     * 子弹射击方向 (向上发射：1，向下发射：-1)
     */
    protected int direction = 1;
    /**
     * 道具数量
     */
    protected int propNum;
    public EnemyAircraft(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }
    /**
     * 敌机移动
     */
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    /**
     * 获取敌机的速度
     * @return
     */
    public int getSpeedX() {
        return speedX;
    }

    /**
     * 敌机射击
     * @return
     */
    public List<BaseBullet> shoot() {
        return doShoot(this.getLocationX(), this.getLocationY(), this.getSpeedX(), this.getSpeedY(), direction);
    }

    /**
     * 创建道具
     * @return
     */
    public List<BaseProp> createProps() {
        List<BaseProp> props = new LinkedList<BaseProp>();
        int x = this.getLocationX();
        int y = this.getLocationY() + direction * 2;
        int speedX = 0;
        int speedY = 10 + direction * 5;
        PropFactory propFactory;
        BaseProp prop;
        for (int i = 0; i < propNum; i++) {
            Random random = new Random();
            double randomNumber = random.nextDouble(); // 生成一个0到1之间的随机数
            if (randomNumber <= 0.30) {
                propFactory = new BloodPropFactory();
            } else if (randomNumber <= 0.60) {
                propFactory = new BombPropFactory();
            } else if (randomNumber <= 0.75) {
                propFactory = new BulletPropFactory();
            } else if(randomNumber <= 0.90) {
                propFactory = new BulletPlusPropFactory();
            } else {
                propFactory = null;
            }
            if (propFactory != null) {
                prop = propFactory.createProp(x + (i * 2 - propNum + 1) * 30, y, speedX, speedY);
                props.add(prop);
            }
        }
        return props;
    }

}
