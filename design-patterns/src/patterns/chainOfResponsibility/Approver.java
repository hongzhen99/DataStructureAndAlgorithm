package patterns.chainOfResponsibility;

/**
 * @ClassName: Aprover
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 20:40
 */
public abstract class Approver {
    //含有下一个审批人
    Approver approver;

    String name;//处理者姓名
    public Approver(String name) {
        this.name = name;
    }
    //下一个处理者
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
