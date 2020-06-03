package patterns.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 21:49
 */
public class Client {
    public static void main(String[] args) {
        //创建学院
//        ArrayList<College> collegesList = new ArrayList<>();
//
//        Computer computer = new Computer();
//        Info info = new Info();
//        collegesList.add(info);
//        collegesList.add(computer);
//
//        OutPutImpl outPut = new OutPutImpl(collegesList);
//        outPut.printCollege();
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }


    }
}
