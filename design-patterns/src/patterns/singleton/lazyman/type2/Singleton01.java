package patterns.singleton.lazyman.type2;

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

//懒汉式  线程安全 同步方法
//锁方法 效率低
class Singleton{
    private Singleton(){};

    private static Singleton singleton;

    public static synchronized Singleton getInstance(){
        if (singleton==null){
            singleton =  new Singleton();
        }
        return singleton;
    }
}
