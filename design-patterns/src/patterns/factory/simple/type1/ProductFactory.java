package patterns.factory.simple.type1;

/**
 * @ClassName: ProductFactory
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 18:49
 */
public class ProductFactory {

    public static Product produce(String productName) throws Exception {
        switch (productName) {
            case "tv":
                return new Tv();
            case "car":
                return new Car();
            case "air":
                return new Air();
            default:
                throw new Exception("没有该产品");
        }
    }
}
