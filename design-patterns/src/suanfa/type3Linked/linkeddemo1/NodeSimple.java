package suanfa.type3Linked.linkeddemo1;

/**
 * @ClassName: NodeSimple
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/15 15:17
 */
public class NodeSimple {
    public int no;
    public String name;
    public String nickName;
    public NodeSimple next;

    public NodeSimple(int no , String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "NodeSimple{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
