package edu.hitsz.aircraft;

public class BossEnemy extends AbstractEnemyAircraft {
    public BossEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        propNum = 3;
    }
}