package patterns.factory.abstractt.type1.entity;

import patterns.factory.abstractt.type1.productInterface.Tv;

/**
 * @ClassName: Sony
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 20:35
 */
public class Sony implements Tv {
    public Sony(){
        System.out.println("索尼电视机被生产出来了");
    }
}
