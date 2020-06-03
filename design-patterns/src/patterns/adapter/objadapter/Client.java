package patterns.adapter.objadapter;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 16:14
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Voltage220V voltage220V = new Voltage220V();
        Voltage5V v = new VoltageAdapter(voltage220V);
        phone.charging(v);
    }
}
