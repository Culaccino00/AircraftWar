package edu.hitsz.strategy;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.prop.BaseProp;

import java.util.List;

public interface ShootStrategy {
    List<BaseBullet> shootBullet(int locationX, int locationY, int speedX, int speedY, int direction);
}
