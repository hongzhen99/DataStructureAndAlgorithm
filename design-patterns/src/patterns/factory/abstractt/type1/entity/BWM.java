package patterns.factory.abstractt.type1.entity;

import patterns.factory.abstractt.type1.productInterface.Car;

/**
 * @ClassName: BWM
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 20:34
 */
public class BWM implements Car {
    public BWM(){
        System.out.println("一辆宝马生产出来了");
    }
}
