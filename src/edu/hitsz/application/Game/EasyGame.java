package edu.hitsz.application.Game;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.AbstractEnemyAircraft;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Music.MusicPlayer;
import edu.hitsz.factory.*;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class EasyGame extends Game {


    public EasyGame() {
        difficulty = 1;
        try {
            ImageManager.BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        enemyMaxNumber = 4;
    }
    public void increaseDifficulty(){ };
    public void addEnemy() {
        EnemyFactory enemyFactory;
        AbstractEnemyAircraft enemy = null;
        //随机生成EliteEnemy,ElitePlusEnemy和MobEnemy
        if (enemyAircrafts.size() < enemyMaxNumber) {
            if (Math.random() > 0.5) {
                enemyFactory = new MobEnemyFactory();
                enemy = enemyFactory.createEnemy(30, 10);
            }
            else if (Math.random() < 0.8){
                enemyFactory = new EliteEnemyFactory();
                enemy = enemyFactory.createEnemy(60, 10);
            }
            else {
                enemyFactory = new ElitePlusEnemyFactory();
                enemy = enemyFactory.createEnemy(60, 10);
            }
            enemyAircrafts.add(enemy);
        }
    }

}
