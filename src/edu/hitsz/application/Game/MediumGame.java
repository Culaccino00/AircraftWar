package edu.hitsz.application.Game;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Music.MusicPlayer;
import edu.hitsz.factory.*;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class MediumGame extends Game{
    public MediumGame() {
        difficulty = 2;
        try {
            ImageManager.BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg2.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        enemyMaxNumber = 6;
        thredhold = 300;
    }

    public void increaseDifficulty() {
        if(enemyMaxNumber <= 10){
            enemyMaxNumber += 1;
        }
        if(timeInterval >= 15){
            timeInterval -= 2;
        }
        if(increaseThreshold >= 150){
            increaseThreshold -= 10;
        }
        if(eliteProbability <= 0.3){
            eliteProbability += 0.02;
        }
        System.out.println("提高难度！精英机概率："+ ((0.8 - eliteProbability * 0.5)-(0.5 - eliteProbability)) +"，飞机射击周期及敌机产生周期缩小倍率："+ (double)timeInterval/40 +"，屏幕中出现的敌机最大数量提升倍率："+ (double)enemyMaxNumber/6 +"，Boss敌机产生的分数阈值间隔缩小倍率："+ (double)increaseThreshold/200);
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
            if(bossExistFlag == false) {//每获得100分，产生boss
                enemyFactory = new BossEnemyFactory();
                enemy = enemyFactory.createEnemy();
                System.out.println("产生boss敌机");
                enemyAircrafts.add(enemy);
                bossExistFlag = true;
                bossNumber++;
                bossMusicThread = MusicPlayer.getMusicPlayer().playMusic("src/videos/bgm_boss.wav");
            }
            thredhold = thredhold + increaseThreshold;
        }
    }
}
