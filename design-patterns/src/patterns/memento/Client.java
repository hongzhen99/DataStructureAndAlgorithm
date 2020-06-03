package patterns.memento;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/2 12:57
 */
public class Client {
    public static void main(String[] args) {
        //
        Originator status = new Originator();
        //新建备忘录
        Caretaker caretaker = new Caretaker();
        //存档1
        status.setState("状态1 xxx");
        caretaker.add(1,status.save());
        //存档2
        status.setState("状态2 xxx");
        caretaker.add(2,status.save());
        //存档3
        status.setState("状态3 xxx");
        caretaker.add(3,status.save());

        System.out.println(status.getState());
        //恢复到状态1   从备忘录里面取出状态  赋给当前状态
        status.getStateFromMemento(caretaker.getSta(1));

        System.out.println(status.getState());
    }

}
