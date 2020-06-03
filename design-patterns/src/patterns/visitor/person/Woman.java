package patterns.visitor.person;

import patterns.visitor.Action;
import patterns.visitor.Person;

/**
 * @ClassName: Women
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 18:18
 */
public class Woman extends Person {

    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
