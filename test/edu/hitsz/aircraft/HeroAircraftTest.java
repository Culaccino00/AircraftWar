package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.HeroBullet;
import edu.hitsz.factory.MobEnemyFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class HeroAircraftTest {

    static HeroAircraft heroAircraft;
    static MobEnemyFactory mobEnemyFactory;
    AbstractAircraft mobEnemy;
//    BaseBullet heroBullet;
    @BeforeAll
    static void beforeAll() {

        System.out.println("**--- Executed once before all test methods in this class ---**");
        mobEnemyFactory = new MobEnemyFactory();
        heroAircraft = HeroAircraft.getHeroAircraft();
    }

    @BeforeEach
    void setUp() {
        heroAircraft.setLocation(200,200);
        mobEnemy = mobEnemyFactory.createEnemy(30, 10);
//        heroBullet = new HeroBullet(200,200,0,20,30);
    }

    @AfterEach
    void tearDown() {
        mobEnemy = null;
//        heroBullet = null;
    }

    @ParameterizedTest
    @DisplayName("Test HeroAircraft decreaseHp method")
    @ValueSource(ints = {10,100,1000,2000})
    void decreaseHp(int decrease) {
        int beforeHp = heroAircraft.getHp();
//        assumeTrue(decrease <= beforeHp);
        heroAircraft.decreaseHp(decrease);
        int afterHp = heroAircraft.getHp();
        assertEquals(Math.max(beforeHp - decrease, 0),afterHp);
    }

    @ParameterizedTest
    @DisplayName("Test HeroAircraft crash method")
    @CsvSource({"200,200,200,200","190,210,190,210","210,190,210,190"})
    void crash(int heroX,int heroY, int enemyX, int enemyY) {
        heroAircraft.setLocation(heroX,heroY);
        mobEnemy.setLocation(enemyX,enemyY);
        assertTrue(heroAircraft.crash(mobEnemy));
    }

    @DisplayName("Test HeroAircraft shoot method")
    @org.junit.jupiter.api.Test
    void shoot() {
        List<BaseBullet> bullets = heroAircraft.shoot();
        assertNotNull(bullets);
        assertTrue(bullets.size() == 1);
        for(BaseBullet bullet:bullets){
            assertTrue(bullet instanceof HeroBullet);
            assertTrue(bullet.getSpeedY() < 0);
        }
    }
}