package patterns.factory.fty.type1;

/**
 * @ClassName: Run
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 19:50
 */
public class Run {
    public static void main(String[] args) {
        Factory factory = new TvFactory();
        factory.produce();
    }
}
