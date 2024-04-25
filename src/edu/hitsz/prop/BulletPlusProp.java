package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.strategy.RingShootStrategy;
import edu.hitsz.strategy.ScatterShootStrategy;
import edu.hitsz.strategy.ShootStrategy;

public class BulletPlusProp  extends BaseProp{
    public BulletPlusProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }
    @Override
    public void effect(AbstractAircraft aircraft){
        aircraft.setStrategy(new RingShootStrategy());
        System.out.println("FireSupplyPro active!");
        vanish();
    }
}
