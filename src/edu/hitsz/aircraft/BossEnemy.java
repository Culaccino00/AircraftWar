package edu.hitsz.aircraft;


import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.factory.*;
import edu.hitsz.prop.BaseProp;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BossEnemy extends AbstractAircraft {
    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */
//    private int shootNum = 20;
    /**
     * 子弹伤害
     */
//    private int power = 10;
    /**
     * 子弹射击方向 (向上发射：1，向下发射：-1)
     */
    private int direction = 1;
    private int propNum = 3;

    public BossEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }


    public int getSpeedX() {
        return speedX;
    }

    @Override
    public List<BaseBullet> shoot() {
        return doShoot(this.getLocationX(), this.getLocationY(), this.getSpeedX(), this.getSpeedY(), direction);
    }

    @Override
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