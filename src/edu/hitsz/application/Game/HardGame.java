package edu.hitsz.application.Game;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.AbstractEnemyAircraft;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Music.MusicPlayer;
import edu.hitsz.factory.*;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class HardGame extends Game{
    private int increasehp = 0;
    public HardGame() {
        difficulty = 3;
        try {
            ImageManager.BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg3.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cycleDuration = 460;
        enemyMaxNumber = 8;
        thredhold = 200;
        heroCycleDuration = 460;
    }
    public void increaseDifficulty() {
        System.out.print("提高难度！");
        enemyMaxNumber += 2;
        System.out.print("屏幕中出现的敌机最大数量提升倍率："+ (double)enemyMaxNumber/8 +"，");
        if(cycleDuration >= 300){
            cycleDuration -= 20;
            System.out.print("敌机射击周期及敌机产生周期缩小倍率："+ (double)cycleDuration/460+"，");
        }
        if(heroCycleDuration >= 340){
            heroCycleDuration -= 10;
            System.out.print("英雄机射击周期缩小倍率："+ (double)heroCycleDuration/460+"，");
        }
        if(increaseThreshold >= 100){
            increaseThreshold -= 20;
            System.out.print("Boss敌机产生的分数阈值间隔缩小倍率："+ (double)increaseThreshold/300+"，");
        }
        if(eliteProbability <= 0.5){
            eliteProbability += 0.10;
            System.out.print("精英机概率："+ ((0.8 - eliteProbability * 0.5)-(0.5 - eliteProbability) + "，"));
        }
        if(increasehp <= 20) {
            increasehp += 2;
            System.out.print("敌机血量增加：" + increasehp + "。");
        }
        System.out.println();
    }
    public void addEnemy() {
        EnemyFactory enemyFactory;
        AbstractEnemyAircraft enemy = null;
        //随机生成EliteEnemy,ElitePlusEnemy和MobEnemy
        if (enemyAircrafts.size() < enemyMaxNumber) {
            if (Math.random() < 0.5 - eliteProbability) {
                enemyFactory = new MobEnemyFactory();
                enemy = enemyFactory.createEnemy(30 + increasehp, 10 );
            }
            else if (Math.random() < 0.8 - eliteProbability * 0.5){
                enemyFactory = new EliteEnemyFactory();
                enemy = enemyFactory.createEnemy(60 + increasehp, 10 );
            }
            else {
                enemyFactory = new ElitePlusEnemyFactory();
                enemy = enemyFactory.createEnemy(60 + increasehp, 10 );
            }
            enemyAircrafts.add(enemy);
        }

        if( score >= thredhold){
            if(!bossExistFlag) {
                enemyFactory = new BossEnemyFactory();
                enemy = enemyFactory.createEnemy(150 + bossNumber * 200, 0);
                //Boss敌机血量随bossNumber增加而增加
                System.out.println("第"+bossNumber+"次产生boss敌机!Boss机血量倍率："+(double)(150 + bossNumber * 200)/350);
                enemyAircrafts.add(enemy);
                bossExistFlag = true;
                bossNumber++;
                bossMusicThread = MusicPlayer.getMusicPlayer().playMusic("src/videos/bgm_boss.wav");
            }
            thredhold = thredhold + increaseThreshold;
        }
    }
}
