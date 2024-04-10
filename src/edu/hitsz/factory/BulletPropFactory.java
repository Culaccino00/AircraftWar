package edu.hitsz.factory;

import edu.hitsz.prop.BaseProp;
import edu.hitsz.prop.BloodProp;
import edu.hitsz.prop.BulletProp;

public class BulletPropFactory implements PropFactory{
    public BaseProp createProp(int locationX, int locationY, int speedX, int speedY) {
        BaseProp prop = new BulletProp(locationX, locationY, speedX, speedY);
        return prop;
    }
}