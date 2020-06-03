package patterns.factory.abstractt.type1;

/**
 * @ClassName: Run
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 20:37
 */
public class Run {
    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        factoryA.produceCar();

        FactoryB factoryB = new FactoryB();
        factoryB.produceTv();
    }
}
