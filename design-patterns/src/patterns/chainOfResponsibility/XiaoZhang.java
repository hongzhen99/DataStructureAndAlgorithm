package patterns.chainOfResponsibility;

/**
 * @ClassName: XiaoZhang
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 20:51
 */
public class XiaoZhang extends Approver{

    public XiaoZhang(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() > 10000){
            System.out.println("编号"+purchaseRequest.getId()+"被 "+this.name+"处理了");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
