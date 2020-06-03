package patterns.visitor.evaluate;

import patterns.visitor.Action;
import patterns.visitor.Person;

/**
 * @ClassName: Success
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 18:17
 */
public class Fail extends Action {
    @Override
    public void getManResult(Person man) {
        System.out.println("男失败");
    }

    @Override
    public void getWomanResult(Person woman) {
        System.out.println("女失败");
    }
}
