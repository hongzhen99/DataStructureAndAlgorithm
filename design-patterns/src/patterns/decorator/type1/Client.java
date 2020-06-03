package patterns.decorator.type1;

import patterns.decorator.type1.coffee.LongBlack;
import patterns.decorator.type1.drink.Drink;
import patterns.decorator.type1.peiliao.Milk;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 0:25
 */
public class Client {

    public static void main(String[] args) {
        //点一份
        Drink longBlack = new LongBlack();
        System.out.println("longBlack价格"+longBlack.cost());
        //加一份牛奶
        longBlack = new Milk(longBlack);
        System.out.println(""+longBlack.getDes());
        System.out.println("加入牛奶后的价格"+longBlack.cost());


    }
}
