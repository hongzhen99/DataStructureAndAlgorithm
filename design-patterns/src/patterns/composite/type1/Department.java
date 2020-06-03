package patterns.composite.type1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Universite
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/18 14:46
 */
public class Department extends OrganizationComponent{

    public Department(String name, String des) {
        super(name, des);
    }

    //叶子节点 不需要实现 add 与 remove
    @Override
    protected void print() {
        System.out.println(getName());

    }
}
