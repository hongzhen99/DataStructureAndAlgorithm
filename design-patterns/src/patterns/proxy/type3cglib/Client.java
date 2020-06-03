package patterns.proxy.type3cglib;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/22 20:02
 */
public class Client {
    public static void main(String[] args) {
        //目标对象
        TeacherImpl target = new TeacherImpl();

        ProxyFactory cglib = new ProxyFactory(target);
        TeacherImpl teacher = (TeacherImpl) cglib.GetProxyInstance();
        System.out.println(teacher.sayHello("asd"));
    }
}
