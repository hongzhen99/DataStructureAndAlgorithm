package patterns.strategy.xingwei;

import patterns.strategy.Strategy;

/**
 * @ClassName: YesFly
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 15:19
 */
public class YesFlyStrategy implements Strategy {
    @Override
    public void fly() {
        System.out.println("我会飞");
    }
}
