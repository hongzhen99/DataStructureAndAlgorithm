package patterns.proxy.type1static;

/**
 * @ClassName: TeacherProxy
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/21 22:59
 */
public class TeacherProxy implements Teacher{

    Teacher teacher;
    public TeacherProxy(Teacher teacher){
        this.teacher = teacher;
    }

    @Override
    public void teach() {
        System.out.println("开始代理");
        teacher.teach();
    }
}
