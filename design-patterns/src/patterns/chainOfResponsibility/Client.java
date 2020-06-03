package patterns.chainOfResponsibility;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 20:51
 */
public class Client {
    public static void main(String[] args) {
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 50011, 123);

        //创建审批人
        Xi xi = new Xi("王系主任");
        Yuan yuan = new Yuan("李院主任");
        FuXiaoZhang fuXiaoZhang = new FuXiaoZhang("郭副校长");
        XiaoZhang xiaoZhang = new XiaoZhang("田校长");

        //创建联系  链表
        xi.setApprover(yuan);
        yuan.setApprover(fuXiaoZhang);
        fuXiaoZhang.setApprover(xiaoZhang);
        xiaoZhang.setApprover(xi);

        xi.processRequest(purchaseRequest);


    }
}
