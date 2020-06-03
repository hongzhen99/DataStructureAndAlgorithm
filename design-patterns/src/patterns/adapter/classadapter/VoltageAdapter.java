package patterns.adapter.classadapter;

/**
 * @ClassName: VoltageAdapter
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 16:11
 */
//适配器
public class VoltageAdapter extends Voltage220V implements Voltage5V{
    @Override
    public int out5v() {
        int src = super.out220v();
        int n = src/44;
        return n;
    }
}
