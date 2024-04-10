package edu.hitsz.factory;

import edu.hitsz.prop.BaseProp;
import edu.hitsz.prop.BloodProp;
import edu.hitsz.prop.BombProp;

public class BombPropFactory implements PropFactory{
    public BaseProp createProp(int locationX, int locationY, int speedX, int speedY) {
        BaseProp prop = new BombProp(locationX, locationY, speedX, speedY);
        return prop;
    }
}