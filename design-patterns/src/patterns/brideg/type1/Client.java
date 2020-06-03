package patterns.brideg.type1;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/15 23:41
 */
public class Client {
    public static void main(String[] args) {
        //获取样式加手机
        FoldedPhone foldedPhone = new FoldedPhone(new HuaWei());
        foldedPhone.open();
        foldedPhone.call();
        foldedPhone.close();


    }
}
