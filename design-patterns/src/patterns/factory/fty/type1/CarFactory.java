package patterns.factory.fty.type1;

/**
 * @ClassName: CarFactory
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 19:49
 */
public class CarFactory implements Factory {
    @Override
    public Product produce() {
        return new Car();
    }
}