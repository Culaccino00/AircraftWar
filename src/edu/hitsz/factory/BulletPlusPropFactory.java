package edu.hitsz.factory;

import edu.hitsz.prop.BaseProp;
import edu.hitsz.prop.BulletPlusProp;
import edu.hitsz.prop.BulletProp;

public class BulletPlusPropFactory implements PropFactory{
    public BaseProp createProp(int locationX, int locationY, int speedX, int speedY) {
        BaseProp prop = new BulletPlusProp(locationX, locationY, speedX, speedY);
        return prop;
    }
}