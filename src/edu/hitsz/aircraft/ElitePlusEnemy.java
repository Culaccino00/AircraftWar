package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.factory.*;
import edu.hitsz.prop.BaseProp;

import java.util.LinkedList;
import java.util.List;

public class ElitePlusEnemy extends AbstractAircraft{
    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */
//    private int shootNum = 3;
    /**
     * 子弹伤害
     */
//    private int power = 10;
    /**
     * 子弹射击方向 (向上发射：1，向下发射：-1)
     */
    private int direction = 1;
    public ElitePlusEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }
    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
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
        int y = this.getLocationY() + direction*2;
        int speedX = 0;
        int speedY = this.getSpeedY() + direction*5;
        PropFactory propFactory;
        BaseProp prop;
        if (Math.random() <= 30.0 / 100) {
            propFactory = new BloodPropFactory();
        } else if (Math.random() > 30.0 / 100 && Math.random() <= 60.0 / 100 ) {
            propFactory = new BombPropFactory();
        } else if (Math.random() > 60.0 / 100 && Math.random() <= 75.0 /100){
            propFactory = new BulletPropFactory();
        }else if (Math.random() > 75.0 / 100 && Math.random() <= 90.0 /100){
            propFactory = new BulletPlusPropFactory();
        }else{
            return props;
        }
        prop = propFactory.createProp(x, y, speedX, speedY);
        props.add(prop);
        return props;
    }

}
