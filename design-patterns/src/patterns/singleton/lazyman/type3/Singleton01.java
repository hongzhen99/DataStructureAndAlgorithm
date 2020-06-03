package patterns.singleton.lazyman.type3;

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
//双重检查  同时解决懒加载问题
//建议这个
class Singleton{
    private Singleton(){};

    private static volatile Singleton singleton;

    public static Singleton getInstance(){
        if (singleton==null){
            synchronized(Singleton.class){
                if (singleton==null){
                    singleton =  new Singleton();
                }
            }
        }
        return singleton;
    }
}
