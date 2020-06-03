package patterns.brideg.type1;

/**
 * @ClassName: Iphone
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/15 23:29
 */
public class Iphone implements Brand{
    @Override
    public void open() {
        System.out.println("Iphone开机");
    }

    @Override
    public void close() {
        System.out.println("Iphone关机");
    }

    @Override
    public void call() {
        System.out.println("Iphone打电话");
    }
}
