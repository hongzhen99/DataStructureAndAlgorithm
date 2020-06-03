package patterns.iterator;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @ClassName: ComputerIterator
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 21:12
 */
//数组方式
public class ComputerIterator implements Iterator {
    Department[] departments;
    int position = 0;//下标
    public ComputerIterator(Department[] departments){
        this.departments = departments;
    }
    @Override
    public boolean hasNext() {
        if (position >= departments.length || departments[position] == null){
            return false;
        }else {
            return true;
        }
    }
    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }
}
