package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.strategy.ScatterShootStrategy;

public class BulletProp extends BaseProp{
    public BulletProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }
    @Override
    public void effect(AbstractAircraft aircraft){
        aircraft.setStrategy(new ScatterShootStrategy());
        System.out.println("FireSupply active!");
        vanish();
    }
}
