package patterns.chainOfResponsibility;

/**
 * @ClassName: Xi
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 20:46
 */
public class Xi extends Approver{

    public Xi(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() <= 1000){
            System.out.println("编号"+purchaseRequest.getId()+"被 "+this.name+"处理了");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
