package patterns.iterator;

import java.util.Iterator;

/**
 * @ClassName: College
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 21:08
 */
public interface College {
    //获取
    public String getName();
    //添加
    public void addDepartment(String name, String desc);

    //创建迭代器
    public Iterator<College> createIterator();
}
