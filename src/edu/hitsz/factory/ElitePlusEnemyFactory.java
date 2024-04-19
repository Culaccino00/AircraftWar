package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.EliteEnemy;
import edu.hitsz.aircraft.ElitePlusEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class ElitePlusEnemyFactory implements EnemyFactory{
    @Override
    public AbstractAircraft createEnemy() {
        AbstractAircraft eliteEnemy;
        System.out.println("ElitePlusEnemyFactory createEnemy");
        if (Math.random() < 0.25 || (Math.random() >0.5 && Math.random()  < 0.75)) {
            eliteEnemy = new ElitePlusEnemy(
                    (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),3, 10, 10);
        } else {
            eliteEnemy = new ElitePlusEnemy(
                    (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),-3, 10, 10);
        }
        return eliteEnemy;
    }
}
