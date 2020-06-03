package patterns.strategy.duixiang;

import patterns.strategy.AirPlane;
import patterns.strategy.Strategy;
import patterns.strategy.xingwei.YesFlyStrategy;

/**
 * @ClassName: PeoperPlane
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 15:35
 */
public class BigPlane extends AirPlane {

    public BigPlane(){
        setStrategy(new YesFlyStrategy());
    }

    public void fly(){
        getStrategy().fly();
    }


    @Override
    public Strategy getStrategy() {
        return super.getStrategy();
    }

    @Override
    public void setStrategy(Strategy strategy) {
        super.setStrategy(strategy);
    }
}
