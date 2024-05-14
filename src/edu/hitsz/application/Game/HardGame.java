package edu.hitsz.application.Game;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Music.MusicPlayer;
import edu.hitsz.factory.*;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class HardGame extends Game{
    public HardGame() {
        difficulty = 3;
        try {
            ImageManager.BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg3.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        enemyMaxNumber = 8;
        thredhold = 200;
    }
    public void increaseDifficulty() {
        if(enemyMaxNumber <= 15){
            enemyMaxNumber += 2;
        }
        if(timeInterval >= 12){
            timeInterval -= 1;
        }
        if(increaseThreshold >= 100){
            increaseThreshold -= 20;
        }
        if(eliteProbability <= 0.2){
            eliteProbability += 0.04;
        }
        System.out.println("提高难度！精英机概率："+ ((0.8 - eliteProbability * 0.5)-(0.5 - eliteProbability)) +"，飞机射击周期及敌机产生周期缩小倍率："+ (double)timeInterval/40 +"，屏幕中出现的敌机最大数量提升倍率："+ (double)enemyMaxNumber/8 +"，Boss敌机产生的分数阈值间隔缩小倍率："+ (double)increaseThreshold/300);
    }
    public void addEnemy() {
        EnemyFactory enemyFactory;
        AbstractAircraft enemy = null;
        //随机生成EliteEnemy,ElitePlusEnemy和MobEnemy
        if (enemyAircrafts.size() < enemyMaxNumber) {
            if (Math.random() < 0.5 - eliteProbability) {
                enemyFactory = new MobEnemyFactory();
                enemy = enemyFactory.createEnemy();
            }
            else if (Math.random() < 0.8 - eliteProbability * 0.5){
                enemyFactory = new EliteEnemyFactory();
                enemy = enemyFactory.createEnemy();
            }
            else {
                enemyFactory = new ElitePlusEnemyFactory();
                enemy = enemyFactory.createEnemy();
            }
            enemyAircrafts.add(enemy);
        }

        if( score >= thredhold){
            if(!bossExistFlag) {
                enemyFactory = new BossEnemyFactory();
                enemy = enemyFactory.createEnemy();
                //Boss敌机血量随bossNumber增加而增加
                enemyFactory.sethp(150 + bossNumber * 100);
                System.out.println("第"+bossNumber+"次产生boss敌机!Boss机血量倍率："+(double)(150 + bossNumber * 100)/250);
                enemyAircrafts.add(enemy);
                bossExistFlag = true;
                bossNumber++;
                bossMusicThread = MusicPlayer.getMusicPlayer().playMusic("src/videos/bgm_boss.wav");
            }
            thredhold = thredhold + increaseThreshold;
        }
    }
}
