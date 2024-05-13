package edu.hitsz.strategy;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class StraightShootStrategy implements ShootStrategy{
    @Override
    public List<BaseBullet> shootBullet(int locationX, int locationY, int speedX, int speedY, int direction) {
        /**
         * 子弹一次发射数量
         */
        int shootNum = 1;
        /**
         * 子弹伤害
         */
        int power = (direction > 0) ? 10 : 30;
        List<BaseBullet> res = new LinkedList<>();
        int x = locationX;
        int y = locationY + direction*2;
        int speedx = 0 + speedX;
        int speedy = (direction > 0) ? (speedY + direction*5) : (speedY + direction*10);
        BaseBullet bullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            if(direction > 0)
                bullet = new EnemyBullet(x + (i*2 - shootNum + 1)*10, y, speedx, speedy, power);
            else
                bullet = new HeroBullet(x + (i*2 - shootNum + 1)*10, y, speedx, speedy, power);
            res.add(bullet);
        }
        return res;
    }
}
