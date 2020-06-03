package patterns.proxy.type2dynamic;

/**
 * @ClassName: TeacherImpl
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/21 22:59
 */
public class TeacherImpl implements Teacher {
    @Override
    public void teach() {
        System.out.println("我在授课");
    }

    @Override
    public String sayHello(String name) {
        return "hello" + name;
    }
}
