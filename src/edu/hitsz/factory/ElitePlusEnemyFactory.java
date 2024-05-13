package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.ElitePlusAbstractEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.strategy.ScatterShootStrategy;

public class ElitePlusEnemyFactory implements EnemyFactory{
    @Override
    public void sethp(int hp){};
    @Override
    public AbstractAircraft createEnemy() {
        AbstractAircraft eliteEnemy;
        if (Math.random() < 0.25 || (Math.random() >0.5 && Math.random()  < 0.75)) {
            eliteEnemy = new ElitePlusAbstractEnemy(
                    (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),3, 10, 60);
        } else {
            eliteEnemy = new ElitePlusAbstractEnemy(
                    (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),-3, 10, 60);
        }
        eliteEnemy.setStrategy(new ScatterShootStrategy());
        return eliteEnemy;
    }
}