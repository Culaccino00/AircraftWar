package edu.hitsz.strategy;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class ScatterShootStrategy implements ShootStrategy{
    @Override
    public List<BaseBullet> shootBullet(int locationX, int locationY, int speedX, int speedY, int direction) {
        int shootNum = 3;
        int power = (direction > 0) ? 10 : 30;
        List<BaseBullet> res = new LinkedList<>();
        int x = locationX;
        int y = locationY + direction*2;
        int speedx;
        int speedy = (direction > 0) ? (speedY + direction*5) : (speedY + direction*10);
        BaseBullet bullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            if(i == 0)  speedx = -2;
            else if(i == 1) speedx = 0;
            else speedx = 2;
            if(direction > 0) {
                bullet = new EnemyBullet(x + (i * 2 - shootNum + 1) * 10, y, speedx + speedX, speedy, power);
            }else {
                bullet = new HeroBullet(x + (i * 2 - shootNum + 1) * 10, y, speedx + speedX, speedy, power);
            }
            res.add(bullet);
        }
        return res;
    }
}
