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

public class ElitePlusEnemy extends AbstractAircraft{
    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */
    private int shootNum = 3;
    /**
     * 子弹伤害
     */
    private int power = 10;
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
        List<BaseBullet> res = new LinkedList<>();
        int x = this.getLocationX();
        int y = this.getLocationY() + direction*2;
        int speedX ;
        int speedY = this.getSpeedY() + direction*5;
        BaseBullet bullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            if(i == 0)  speedX = -2;
            else if(i == 1) speedX = 0;
            else speedX = 2;
//            x + (i*2 - shootNum + 1)*10
            bullet = new EnemyBullet(x + (i*2 - shootNum + 1)*10, y, speedX + this.getSpeedX() , speedY, power);
            res.add(bullet);
        }
        return res;
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
        } else if (Math.random() >= 30.0 / 100 && Math.random() <= 60.0 / 100 ) {
            propFactory = new BombPropFactory();
        } else if (Math.random() >= 60.0 / 100 && Math.random() <= 90.0 /100){
            propFactory = new BulletPropFactory();
        }else{
            return props;
        }
        prop = propFactory.createProp(x, y, speedX, speedY);
        props.add(prop);
        return props;
    }

}
