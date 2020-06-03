package patterns.strategy;

/**
 * @ClassName: airplane
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 15:34
 */
public class AirPlane {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
