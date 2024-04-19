package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.BossEnemy;
import edu.hitsz.aircraft.EliteEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class BossEnemyFactory implements EnemyFactory{
    public AbstractAircraft createEnemy() {
        AbstractAircraft eliteEnemy;
        if (Math.random() < 0.25 || (Math.random() >0.5 && Math.random()  < 0.75)) {
            eliteEnemy = new BossEnemy(
                    (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.15),3, 0, 50);
        } else {
            eliteEnemy = new BossEnemy(
                    (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.15),-3, 0, 50);
        }
        return eliteEnemy;
    }

}
