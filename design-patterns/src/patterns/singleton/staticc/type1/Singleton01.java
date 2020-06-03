package patterns.singleton.staticc.type1;

/**
 * @ClassName: Singleton01
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/11 17:43
 */
public class Singleton01 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton==singleton1);
    }
}

//懒汉式  线程安全
//使用静态内部类  推荐使用
class Singleton{
    private Singleton(){};

    private static class SingletonInstance{
        private static final Singleton SINGLETON = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstance.SINGLETON;
    }
}
