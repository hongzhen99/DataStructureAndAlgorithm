package patterns.chainOfResponsibility;

/**
 * @ClassName: FuXiaoZhang
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 20:50
 */
public class FuXiaoZhang extends Approver{

    public FuXiaoZhang(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() > 5000 && purchaseRequest.getPrice() <= 10000){
            System.out.println("编号"+purchaseRequest.getId()+"被 "+this.name+"处理了");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
