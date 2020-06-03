package suanfa.type3Linked.doublelinked;




/**
 * @ClassName: Run
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/16 17:32
 */
public class Run {
    public static void main(String[] args) {
        NodeSimple nodeSimple = new NodeSimple(1, "aaa", "aaa");
        NodeSimple nodeSimple1 = new NodeSimple(2, "bbb", "bbb");
        NodeSimple nodeSimple2 = new NodeSimple(3, "ccc", "ccc");
        NodeSimple nodeSimple3 = new NodeSimple(1, "ccc1", "ccc");
        DoubleLinkedListSimple linkedListSimple = new DoubleLinkedListSimple();
        //测试添加
//        linkedListSimple.add(nodeSimple);
//        linkedListSimple.add(nodeSimple1);
        linkedListSimple.addByOrder(nodeSimple1);
//        linkedListSimple.addByOrder(nodeSimple2);

//        linkedListSimple.delNode(3);
//        linkedListSimple.list();

    }
}
