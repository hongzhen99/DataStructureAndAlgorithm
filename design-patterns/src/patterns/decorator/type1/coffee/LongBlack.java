package patterns.decorator.type1.coffee;

/**
 * @ClassName: LongBlack
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 0:15
 */
public class LongBlack extends Coffee {
    public LongBlack(){
        setDes("Long");
        setPrice(4.0f);
    }

    @Override
    public float cost() {
        return 4.0f;
    }
}
