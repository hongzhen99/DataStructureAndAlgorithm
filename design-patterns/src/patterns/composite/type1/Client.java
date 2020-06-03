package patterns.composite.type1;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/18 14:57
 */
public class Client {
    public static void main(String[] args) {
        //从大到小创建对象  学校
        OrganizationComponent universite = new Universite("清华大学", "one");
        // 学院
        OrganizationComponent collegeComputer = new College("计算机学院", "two");
        OrganizationComponent collegeKj = new College("会计", "two");

        //专业
        collegeComputer.add(new Department("软件工程1","aa1"));
        collegeComputer.add(new Department("软件工程2","aa2"));
        collegeComputer.add(new Department("软件工程3","aa3"));

        collegeKj.add(new Department("会计1","k1"));
        collegeKj.add(new Department("会计2","k2"));
        collegeKj.add(new Department("会计3","k3"));

        universite.add(collegeComputer);
        universite.add(collegeKj);

        universite.print();
    }
}
