package patterns.factory.simple.type1;

/**
 * @ClassName: Run
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 18:49
 */
public class Run {
    public static void main(String[] args) {
        try {
            ProductFactory.produce("air");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ProductFactory2.produce("factory.simple.type1.Air");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
