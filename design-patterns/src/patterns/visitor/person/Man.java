package patterns.visitor.person;

import patterns.visitor.Action;
import patterns.visitor.Person;

/**
 * @ClassName: Man
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 18:18
 */
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
