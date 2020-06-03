package patterns.factory.abstractt.type1.entity;

import patterns.factory.abstractt.type1.productInterface.Car;

/**
 * @ClassName: AoDi
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 20:33
 */
public class AoDi implements Car {
    public AoDi(){
        System.out.println("奥迪车生产出来了");
    }
}
