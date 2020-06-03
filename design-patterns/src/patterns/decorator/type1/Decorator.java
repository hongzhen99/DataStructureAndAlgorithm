package patterns.decorator.type1;

import patterns.decorator.type1.drink.Drink;

/**
 * @ClassName: Decorator
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 0:17
 */
public class Decorator extends Drink {

    private Drink obj;//吧Drink 放入  给他装饰

    public Decorator(Drink obj){
        this.obj = obj;
    }

    @Override
    public float cost() {
        return getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        return super.getDes()+""+ getPrice() + ".."+obj.getDes();
    }
}
