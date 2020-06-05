package patterns.proxy.type1static;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/21 23:00
 */
public class Client {
    public static void main(String[] args) {

        TeacherImpl teacher = new TeacherImpl();

        TeacherProxy teacherProxy = new TeacherProxy(teacher);
        teacherProxy.teach();
    }
}
