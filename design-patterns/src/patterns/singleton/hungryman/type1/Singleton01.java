package patterns.singleton.hungryman.type1;

/**
 * @ClassName: Singleton01
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/11 17:22
 */

public class Singleton01 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1==singleton2);
    }
}
//单例模式---饿汉式
class Singleton {
    //构造器私有化   无法new
    private Singleton(){};

    private final static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }
}