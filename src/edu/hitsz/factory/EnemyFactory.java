package edu.hitsz.factory;
import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.AbstractEnemyAircraft;

public interface EnemyFactory {
    public abstract AbstractEnemyAircraft createEnemy(int hp, int speedY);
}
