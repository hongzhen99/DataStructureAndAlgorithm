package com.singletion;


/**
 * @ClassName: String
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/22 11:49
 * 所谓单例，就是整个程序有且仅有一个实例。该类负责创建自己的对象，同时确保只有一个对象被创建。
 * 在Java，一般常用在工具类的实现或创建对象需要消耗资源。
 *  特点
 *      类构造器私有
 *      持有自己类型的属性
 *      对外提供获取实例的静态方法
 */
//懒汉模式
// 线程不安全，延迟初始化，严格意义上不是不是单例模式
class Singleton {
    private static Singleton singleton =null;
    private Singleton(){};

    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
//饿汉模式
//线程安全，比较常用，但容易产生垃圾，因为一开始就初始化
class Singleton01 {
    private static Singleton01 singleton01 = new Singleton01();
    private Singleton01 (){}

    public static Singleton01 getInstance() {
        return singleton01;
    }
}
//双重锁模式
//线程安全，延迟初始化。这种方式采用双锁机制，
// 安全且在多线程情况下能保持高性能。
class Singleton02{
    private volatile static Singleton02 s2;
    private Singleton02(){}

    public static Singleton02 getInstance(){
        if (s2 == null){
            synchronized (Singleton02.class){
                if (s2 == null){
                    s2 = new Singleton02();
                }
            }
        }
        return s2;
    }
}
//静态内部类单例模式
class Singleton03{
    private Singleton03(){};
    public static Singleton03 getInstance(){
        return Inner.S3;
    }
    private static class Inner{
        private static final Singleton03 S3 = new Singleton03();
    }
}



