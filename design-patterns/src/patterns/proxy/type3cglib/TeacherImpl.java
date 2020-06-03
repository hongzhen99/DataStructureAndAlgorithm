package patterns.proxy.type3cglib;



/**
 * @ClassName: TeacherImpl
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/21 22:59
 */
public class TeacherImpl {

    public void teach() {
        System.out.println("我在授课");
    }


    public String sayHello(String name) {
        return "hello" + name;
    }
}
