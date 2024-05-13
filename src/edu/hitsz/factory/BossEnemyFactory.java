package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.BossAbstractEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.strategy.RingShootStrategy;

public class BossEnemyFactory implements EnemyFactory{
    private int hp = 150;
    public void sethp(int hp){
        this.hp = hp;
    }
    public AbstractAircraft createEnemy() {
        AbstractAircraft eliteEnemy;
        if (Math.random() < 0.25 || (Math.random() >0.5 && Math.random()  < 0.75)) {
            eliteEnemy = new BossAbstractEnemy(
                    (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.15),3, 0, hp);
        } else {
            eliteEnemy = new BossAbstractEnemy(
                    (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.15),-3, 0, hp);
        }
        eliteEnemy.setStrategy(new RingShootStrategy());
        return eliteEnemy;
    }

}
