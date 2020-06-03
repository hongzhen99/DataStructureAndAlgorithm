package patterns.brideg.type1;

/**
 * @ClassName: HuaWei
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/15 23:28
 */
public class HuaWei implements Brand{
    @Override
    public void open() {
        System.out.println("HuaWei开机");
    }

    @Override
    public void close() {
        System.out.println("HuaWei关机");
    }

    @Override
    public void call() {
        System.out.println("HuaWei打电话");
    }
}
