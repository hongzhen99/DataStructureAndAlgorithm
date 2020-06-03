package patterns.factory.simple.type1;

/**
 * @ClassName: ProductFactory
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 18:49
 */
public class ProductFactory2 {
    public static Product produce(String className) throws Exception {
        try {
            Product product = (Product) Class.forName(className).newInstance();
            return product;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new Exception("没有该产品");
    }
}
