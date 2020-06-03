package patterns.factory.fty.type1;

/**
 * @ClassName: TvFactory
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 19:49
 */
public class TvFactory implements Factory{
    @Override
    public Product produce() {
        return new Tv();
    }
}
