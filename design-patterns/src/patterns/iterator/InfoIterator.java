package patterns.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: InfoIterator
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 21:17
 */
public class InfoIterator implements Iterator {
    List<Department> departments;//以list方式存放
    int index = -1;//索引

    public InfoIterator(List<Department> departments){
        this.departments = departments;
    }
    //判断list中有没有下一个元素
    @Override
    public boolean hasNext() {
        if (index >= departments.size()-1){
            return false;
        }else {
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departments.get(index);
    }
}
