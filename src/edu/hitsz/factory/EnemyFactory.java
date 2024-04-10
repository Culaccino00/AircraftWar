package edu.hitsz.factory;
import edu.hitsz.aircraft.AbstractAircraft;
public interface EnemyFactory {
    public abstract AbstractAircraft createEnemy();
}
