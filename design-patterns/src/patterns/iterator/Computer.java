package patterns.iterator;

import java.util.Iterator;

/**
 * @ClassName: Computer
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 21:12
 */
public class Computer implements College{
    Department[] departments;
    int num;//保存数组当前个数
    public Computer(){
        departments =  new Department[5];
        addDepartment("Java","牛逼");
        addDepartment("Mysql","qwe");
        addDepartment("Tomcat","asd");
    }
    @Override
    public String getName() {
        return "计算机学院";
    }
    //添加元素
    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[num] = department;
        num += 1;
    }
    //获取迭代器
    @Override
    public Iterator createIterator() {
        return new ComputerIterator(departments);
    }
}
