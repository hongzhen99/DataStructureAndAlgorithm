package patterns.decorator.type1.peiliao;

import patterns.decorator.type1.Decorator;
import patterns.decorator.type1.drink.Drink;

/**
 * @ClassName: Chocolate
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 0:23
 */
public class Chocolate extends Decorator {

    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3.0f);
    }


}
