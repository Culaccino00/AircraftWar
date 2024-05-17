package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.AbstractEnemyAircraft;
import edu.hitsz.aircraft.MobEnemy;
import edu.hitsz.application.Game.Game;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.basic.Observer;
import edu.hitsz.prop.BombProp;
import edu.hitsz.strategy.NoneShootStrategy;


public class MobEnemyFactory implements EnemyFactory{
    @Override
    public AbstractEnemyAircraft createEnemy(int hp, int speedY) {
        AbstractEnemyAircraft mobEnemy = new MobEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                0, speedY, hp
        );
        mobEnemy.setStrategy(new NoneShootStrategy());
        return mobEnemy;
    }
}

