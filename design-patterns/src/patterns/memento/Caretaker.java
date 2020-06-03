package patterns.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Caretake
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/2 12:54
 */
//用于存储备忘录对象
public class Caretaker {
    private Map<Integer,Memento> mementoMap = new HashMap<>();

    public void add(int index,Memento memento){
        mementoMap.put(index,memento);
    }

    public Memento getSta(int index){
        return mementoMap.get(index);
    }
}
