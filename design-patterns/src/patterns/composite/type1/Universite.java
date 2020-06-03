package patterns.composite.type1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Universite
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/18 14:46
 */
public class Universite extends OrganizationComponent{

    List<OrganizationComponent> list = new ArrayList<>();

    public Universite(String name, String des) {
        super(name, des);
    }
    //重写add
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        list.add(organizationComponent);
    }
    //重写remove
    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        list.remove(organizationComponent);
    }

    @Override
    protected void print() {
        System.out.println("========"+ getName() +"============");
        for (OrganizationComponent item : list){
            item.print();
        }
    }
}
