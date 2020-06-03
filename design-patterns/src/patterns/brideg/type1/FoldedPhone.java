package patterns.brideg.type1;

/**
 * @ClassName: Folded
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/15 23:31
 */
public class FoldedPhone extends Phone{

    public FoldedPhone(Brand brand) {
        super(brand);
    }

    public void open(){
        super.open();
        System.out.println("折叠手机");
    }
    public void close(){
        super.close();
        System.out.println("折叠手机");
    }
    public void call(){
        super.call();
        System.out.println("折叠手机");
    }

}
