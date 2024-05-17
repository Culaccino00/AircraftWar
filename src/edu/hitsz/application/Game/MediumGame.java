package edu.hitsz.application.Game;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.AbstractEnemyAircraft;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Music.MusicPlayer;
import edu.hitsz.factory.*;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class MediumGame extends Game{
    private int increasehp = 0;

    public MediumGame() {
        difficulty = 2;
        try {
            ImageManager.BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg2.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cycleDuration = 500;
        enemyMaxNumber = 6;
        thredhold = 300;
        heroCycleDuration = 450;
    }

    public void increaseDifficulty() {
        System.out.print("提高难度！");
        enemyMaxNumber += 1;
        System.out.print("屏幕中出现的敌机最大数量提升倍率："+ (double)enemyMaxNumber/6 +"，");
        if(cycleDuration >= 400){
            cycleDuration -= 10;
            System.out.print("敌机射击周期及敌机产生周期缩小倍率："+ (double)cycleDuration/500+"，");
        }
        if(heroCycleDuration >= 350){
            heroCycleDuration -= 10;
            System.out.print("英雄机射击周期缩小倍率："+ (double)heroCycleDuration/450+"，");
        }
        if(increaseThreshold >= 150){
            increaseThreshold -= 10;
            System.out.print("Boss敌机产生的分数阈值间隔缩小倍率："+ (double)increaseThreshold/300+"，");
        }
        if(eliteProbability <= 0.3){
            eliteProbability += 0.08;
            System.out.print("精英机概率："+ ((0.8 - eliteProbability * 0.5)-(0.5 - eliteProbability) + "，\n"));
        }
        if(increasehp <= 15) {
            increasehp += 1;
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
                enemy = enemyFactory.createEnemy(150, 0);
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
