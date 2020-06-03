package patterns.visitor;

import patterns.prototype.type1.Per;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: ObjectStructure
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 18:42
 */
public class ObjectStructure {

    private List<Person> personList = new LinkedList<>();

    public void attach(Person person){
        personList.add(person);
    }
    public void detach(Person person){
        personList.remove(person);
    }
    //显示测评
    public void display(Action action){
        for(Person p : personList){
            p.accept(action);
        }
    }
}
