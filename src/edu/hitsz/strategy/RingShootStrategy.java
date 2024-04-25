package edu.hitsz.strategy;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class RingShootStrategy implements ShootStrategy{
    @Override
    public List<BaseBullet> shootBullet(int locationX, int locationY, int speedX, int speedY, int direction) {
        int shootNum = 20;
        int power = (direction > 0) ? 10 : 30;
        List<BaseBullet> res = new LinkedList<>();
        int x = locationX;
        int y = locationY + direction * 2;
        double angleIncrement = 360.0 / shootNum; // 计算每颗子弹之间的角度增量

        for (int i = 0; i < shootNum; i++) {
            // 计算子弹的初始速度，这里假设子弹速度为固定值
            double speed = 10;
            double angle = Math.toRadians(i * angleIncrement); // 将角度转换为弧度
            int speedx = (int) (speed * Math.cos(angle)) + speedX; // 计算X方向的速度分量
            int speedy = (int) (speed * Math.sin(angle)); // 计算Y方向的速度分量
            // 创建子弹对象并添加到结果列表中
            if(direction > 0)
                // 子弹发射位置相对飞机位置向前偏移
                // 多个子弹横向分散
                // 创建子弹对象并添加到结果列表中
                // BaseBullet bullet = new EnemyBullet(x, y, speedx, speedy, power);
                res.add(new EnemyBullet(x, y, speedx, speedy, power));
            else
                // BaseBullet bullet = new HeroBullet(x, y, speedx, speedy, power);
                res.add(new HeroBullet(x, y, speedx, speedy, power));
        }
        return res;
    }
}
