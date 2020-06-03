package patterns.strategy.xingwei;

import patterns.strategy.Strategy;

/**
 * @ClassName: NoFlyStrategy
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 15:19
 */
public class NoFlyStrategy implements Strategy {
    @Override
    public void fly() {
        System.out.println("我不会飞");
    }
}
