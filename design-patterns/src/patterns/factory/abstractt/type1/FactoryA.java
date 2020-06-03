package patterns.factory.abstractt.type1;

import patterns.factory.abstractt.type1.entity.BWM;
import patterns.factory.abstractt.type1.entity.LeTV;
import patterns.factory.abstractt.type1.productInterface.Car;
import patterns.factory.abstractt.type1.productInterface.Tv;

/**
 * @ClassName: FactoryA
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 20:36
 */
public class FactoryA implements Factory{
    @Override
    public Tv produceTv() {
        return new LeTV();
    }

    @Override
    public Car produceCar() {
        return new BWM();
    }
}
