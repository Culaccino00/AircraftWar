package edu.hitsz.factory;

import edu.hitsz.prop.BaseProp;
import edu.hitsz.prop.BloodProp;

public class BloodPropFactory implements PropFactory{
    public BaseProp createProp(int locationX, int locationY, int speedX, int speedY) {
        BaseProp prop = new BloodProp(locationX, locationY, speedX, speedY);
        return prop;
    }
}
