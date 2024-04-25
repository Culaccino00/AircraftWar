package edu.hitsz.strategy;

import edu.hitsz.bullet.BaseBullet;

import java.util.LinkedList;
import java.util.List;

public class NoneShootStrategy implements ShootStrategy {
    @Override
    public List<BaseBullet> shootBullet(int locationX, int locationY, int speedX, int speedY, int direction) {
        return new LinkedList<>();
    }
}
