package patterns.singleton.meiju.type1;

/**
 * @ClassName: Singleton01
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/11 18:11
 */
public class Singleton01 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance==instance2);
    }
}
//枚举 单例模式 防止反射
enum Singleton{
    INSTANCE;//属性
    public void ok(){
        System.out.println("ok");
    }
}