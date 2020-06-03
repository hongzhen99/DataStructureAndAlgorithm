package patterns.chainOfResponsibility;

/**
 * @ClassName: Yuan
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 20:49
 */
public class Yuan extends Approver{


    public Yuan(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() > 1000 && purchaseRequest.getPrice() <= 5000){
            System.out.println("编号"+purchaseRequest.getId()+"被 "+this.name+"处理了");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
