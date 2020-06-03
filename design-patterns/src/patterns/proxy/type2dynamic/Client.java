package patterns.proxy.type2dynamic;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/22 14:11
 */
public class Client {
    public static void main(String[] args) {
        Teacher target = new TeacherImpl();

        Teacher proxyInstance = (Teacher) new ProxyFactory(target).getProxyInstance();


        System.out.println("proxyInstance === " +proxyInstance.getClass());
        proxyInstance.sayHello("bob");
    }
}
