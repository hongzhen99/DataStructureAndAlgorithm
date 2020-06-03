package patterns.visitor;

import patterns.visitor.Action;

/**
 * @ClassName: Person
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 18:16
 */
public abstract class Person {
    //提供一个方法让访问者访问
    public abstract void accept(Action action);
}
