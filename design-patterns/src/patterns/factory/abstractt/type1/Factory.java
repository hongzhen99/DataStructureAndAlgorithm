package patterns.factory.abstractt.type1;

import patterns.factory.abstractt.type1.productInterface.Car;
import patterns.factory.abstractt.type1.productInterface.Tv;

/**
 * @ClassName: Factory
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 20:35
 */
public interface Factory {

    public Tv produceTv();

    public Car produceCar();
}
