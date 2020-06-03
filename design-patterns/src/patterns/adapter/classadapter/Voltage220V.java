package patterns.adapter.classadapter;

/**
 * @ClassName: Voltage
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 16:09
 */
//被适配器
public class Voltage220V {
    public int out220v(){
        int src = 220;
        System.out.println("电压="+src);
        return src;
    }
}
