package patterns.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: OutPutImpl
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 21:45
 */
public class OutPutImpl {
    List<College> list;

    public OutPutImpl(List<College> list){
        this.list = list;
    }

    public void printCollege(){
        //获取迭代器
        Iterator<College> iterator = list.iterator();
        while (iterator.hasNext()){
            College college =  iterator.next();
            System.out.println("======"+ college.getName() +"======");
            printDep(college.createIterator());
        }
    }

    //输出学院输出系
    public void printDep(Iterator iterator){
        while (iterator.hasNext()){
            Department next = (Department)iterator.next();
            System.out.println(next.getName());
        }
    }
}
