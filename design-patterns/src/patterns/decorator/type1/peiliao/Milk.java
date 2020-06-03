package patterns.decorator.type1.peiliao;

import patterns.decorator.type1.Decorator;
import patterns.decorator.type1.drink.Drink;

/**
 * @ClassName: Milk
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 0:24
 */
public class Milk extends Decorator {

    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");//set描述
        setPrice(2.0f);//set价格
    }
}
