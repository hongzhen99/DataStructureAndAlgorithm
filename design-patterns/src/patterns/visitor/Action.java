package patterns.visitor;

import patterns.visitor.person.Man;
import patterns.visitor.person.Woman;

/**
 * @ClassName: Action
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 18:15
 */
public abstract class Action {
    //得到男性评价
    public abstract void getManResult(Person man);
    //
    public abstract void getWomanResult(Person woman);
}
