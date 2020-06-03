package patterns.proxy.type1static;

/**
 * @ClassName: TeacherImpl
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/21 22:59
 */
public class TeacherImpl implements Teacher{
    @Override
    public void teach() {
        System.out.println("我在授课");
    }
}
