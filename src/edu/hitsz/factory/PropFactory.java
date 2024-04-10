package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.prop.BaseProp;

public interface PropFactory {
    public abstract BaseProp createProp(int locationX, int locationY, int speedX, int speedY);
}
