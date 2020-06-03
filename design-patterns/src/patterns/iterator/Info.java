package patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Info
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 21:28
 */
public class Info implements College{

    List<Department> list;

    public Info(){
        list = new ArrayList<Department>();
        addDepartment("信息安全","1233");
        addDepartment("信息安全1","1233");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        list.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoIterator(list);
    }
}
