package edu.hitsz.factory;
import edu.hitsz.aircraft.AbstractAircraft;
public interface EnemyFactory {
    public abstract void sethp(int hp);
    public abstract AbstractAircraft createEnemy();
}
