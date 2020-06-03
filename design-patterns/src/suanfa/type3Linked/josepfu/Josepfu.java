package suanfa.type3Linked.josepfu;


/**
 * @ClassName: Josepfu
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/16 20:57
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.addBoy(1150);
//        circleLinkedList.showBoy();
        long startTime=System.currentTimeMillis();   //获取开始时间
        circleLinkedList.jsoegfu(1,2);

        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }
}

class CircleLinkedList {
    private Boy first = null;

    public void addBoy(int nums){
        if (nums<1)
            return;
        Boy cur = null;//辅助指针
        for (int i = 1; i<= nums; i++){
            Boy boy = new Boy(i);
            if (i==1){
                first = boy;//第一个节点
                first.setNext(first);//自 环
                cur = first; //让curBoy指向第一个
            }else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }
    public void showBoy(){
        if (first ==null)
            return;
        //first不能动
        Boy cur = first;
        do {
            System.out.println("第"+cur.getNo()+"个小孩");
            cur = cur.getNext();
        }while (cur != first);
    }

    /**
     *
     * @param startNum 从第几个小孩开始
     * @param count 数第count的小号离开
     */
    public void jsoegfu(int startNum, int count){
        if(this.first == null || count <= 1)
            return;
        Boy first = this.first; //定位指针 用来第一个小孩的位置
        for(int i = 0; i< startNum-1; i++){
            first = first.getNext();
        }
        Boy cur = first; //辅助指针
        boolean isFirst = true;

        while (true){
            if (cur == cur.getNext()){ //如何cur == cur.getNext()的话 则就剩一个小孩
                System.out.println("剩余"+cur.getNext());
                return;
            }
            if (isFirst){
                for (int i = 0; i< count-2; i++){//第一次数自身
                    cur = cur.getNext();
                }
                isFirst = false;
            }else {
                for (int i = 0; i< count-1; i++){//离开小孩的前一个位置
                    cur = cur.getNext();
                }
            }
            System.out.println(cur.getNext().getNo()+"号小孩离开");
            cur.setNext(cur.getNext().getNext());
        }

    }
}

//Boy节点
class Boy{
    private int no;//编号
    private Boy next;//指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
