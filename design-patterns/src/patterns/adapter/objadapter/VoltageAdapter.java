package patterns.adapter.objadapter;

/**
 * @ClassName: VoltageAdapter
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 16:11
 */
//适配器
public class VoltageAdapter  implements Voltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }



    @Override
    public int out5v() {
        int dst = 0;
        if(null != voltage220V){
            int src = voltage220V.out220v();
            System.out.println("使用对象适配器，进行适配");
            dst = src/44;
            System.out.println("使适配后 电压 = "+ dst);
        }
        return dst;
    }
}
