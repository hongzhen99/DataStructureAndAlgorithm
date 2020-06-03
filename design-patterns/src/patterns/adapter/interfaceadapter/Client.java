package patterns.adapter.interfaceadapter;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 16:45
 */
public class Client {
    public static void main(String[] args) {
        B b = new B(){
            @Override
            public void m1() {
                System.out.println("2332");
            }
        };
        b.m1();
    }
}
