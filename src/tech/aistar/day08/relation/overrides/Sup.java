package tech.aistar.day08.relation.overrides;

import tech.aistar.day08.relation.extend.Animal;
import tech.aistar.day08.relation.extend.Dog;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 18:31
 */
public class Sup {
    public Animal buy(){
        return null;
    }

    public double test(){
        return 0.0;
    }
}

class Sub extends Sup{
    @Override
    public Dog buy(){
        return null;
    }

    @Override
    public double test(){
        return super.test();
    }
}
