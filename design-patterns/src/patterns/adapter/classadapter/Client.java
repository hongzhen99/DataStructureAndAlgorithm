package patterns.adapter.classadapter;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 16:14
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();

        Voltage5V v = new VoltageAdapter();

        phone.charging(v);
    }
}
