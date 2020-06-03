package patterns.decorator.type1.peiliao;

import patterns.decorator.type1.Decorator;
import patterns.decorator.type1.drink.Drink;

/**
 * @ClassName: Soy
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 0:25
 */
public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(1.0f);
    }
}
