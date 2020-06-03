package patterns.factory.abstractt.type1.entity;

import patterns.factory.abstractt.type1.productInterface.Tv;

/**
 * @ClassName: LeTV
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 20:34
 */
public class LeTV implements Tv {
    public LeTV() {
        System.out.println("乐视电视被生产出来了");
    }
}
