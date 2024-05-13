package edu.hitsz.bullet;

import edu.hitsz.basic.Observer;

/**
 * @Author hitsz
 */
public class EnemyBullet extends BaseBullet implements Observer {

    public EnemyBullet(int locationX, int locationY, int speedX, int speedY, int power) {
        super(locationX, locationY, speedX, speedY, power);
    }

    public void update(){
        this.vanish();
    }
}
