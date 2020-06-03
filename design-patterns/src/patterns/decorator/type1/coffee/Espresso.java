package patterns.decorator.type1.coffee;

/**
 * @ClassName: Espresso
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 0:14
 */
public class Espresso extends Coffee {
    public Espresso(){
        setDes("意大利咖啡");
        setPrice(2.0f);
    }

    @Override
    public float cost() {
        return 2.0f;
    }
}
