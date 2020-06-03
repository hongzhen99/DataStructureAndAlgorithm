package patterns.command.light;

/**
 * @ClassName: Client1
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 14:46
 */
public class Client1 {
    public static void main(String[] args) {
        LightReceiver lightReceiver = new LightReceiver();
        lightReceiver.on();
    }
}
