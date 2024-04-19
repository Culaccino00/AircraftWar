package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.factory.BloodPropFactory;
import edu.hitsz.factory.BombPropFactory;
import edu.hitsz.factory.BulletPropFactory;
import edu.hitsz.factory.PropFactory;
import edu.hitsz.prop.BaseProp;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BossEnemy extends AbstractAircraft {
    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */
    private int shootNum = 20;
    /**
     * 子弹伤害
     */
    private int power = 10;
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
        List<BaseBullet> res = new LinkedList<>();
        int x = this.getLocationX();
        int y = this.getLocationY() + direction * 2;
        double angleIncrement = 360.0 / shootNum; // 计算每颗子弹之间的角度增量

        for (int i = 0; i < shootNum; i++) {
            // 计算子弹的初始速度，这里假设子弹速度为固定值
            double speed = 10;
            double angle = Math.toRadians(i * angleIncrement); // 将角度转换为弧度
            int speedX = (int) (speed * Math.cos(angle)) + this.getSpeedX(); // 计算X方向的速度分量
            int speedY = (int) (speed * Math.sin(angle)); // 计算Y方向的速度分量
            // 创建子弹对象并添加到结果列表中
            BaseBullet bullet = new EnemyBullet(x, y, speedX, speedY, power);
            res.add(bullet);
        }
        return res;
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
            } else if (randomNumber <= 0.90) {
                propFactory = new BulletPropFactory();
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