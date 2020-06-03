package patterns.factory.abstractt.type1;

import patterns.factory.abstractt.type1.entity.AoDi;
import patterns.factory.abstractt.type1.entity.Sony;
import patterns.factory.abstractt.type1.productInterface.Car;
import patterns.factory.abstractt.type1.productInterface.Tv;

/**
 * @ClassName: FactoryB
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 20:36
 */
public class FactoryB implements Factory{
    @Override
    public Tv produceTv() {
        return new Sony();
    }

    @Override
    public Car produceCar() {
        return new AoDi();
    }
}
