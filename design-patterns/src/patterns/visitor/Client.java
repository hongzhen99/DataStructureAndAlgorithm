package patterns.visitor;

import patterns.visitor.evaluate.Success;
import patterns.visitor.person.Man;
import patterns.visitor.person.Woman;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 18:21
 */
public class Client {
    public static void main(String[] args) {
        //统一管理
        ObjectStructure objectStructure = new ObjectStructure();
        //参与人
        Man man = new Man();
        Woman woman = new Woman();
        //放入管理
        objectStructure.attach(man);
        objectStructure.attach(woman);
        //创建评分
        Success success = new Success();
        //评分并打印
        objectStructure.display(success);
    }
}
