package patterns.strategy.duixiang;

import patterns.strategy.AirPlane;
import patterns.strategy.Strategy;
import patterns.strategy.xingwei.NoFlyStrategy;

/**
 * @ClassName: PeoperPlane
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 15:35
 */
public class PaperPlane extends AirPlane {

    public PaperPlane(){
        setStrategy(new NoFlyStrategy());
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
