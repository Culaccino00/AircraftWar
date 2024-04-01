package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;


public class BloodProp extends BaseProp{
    public BloodProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }
//加血量30
    @Override
    public void effect(AbstractAircraft aircraft) {
        if(aircraft.getHp()<aircraft.getMaxHp()){
            aircraft.decreaseHp(-30);
        }
//        System.out.println("BloodSupply active!");
        vanish();
    }
}
