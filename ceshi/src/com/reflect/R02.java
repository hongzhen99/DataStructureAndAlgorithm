package com.reflect;

import java.lang.reflect.Constructor;

/**
 * @ClassName: R01
 * @Description: TODO  反射机制 如何通过Class来获取对象
 * @Author: TianHongzhen
 * @Date: 2020/4/28 21:01
 */
public class R02 {
    public static void main(String[] args) throws Exception{

        Class cla2 = Person.class;
        /*
            2、获取构造方法
            Constructor<T>   getConstructor
            Constructor<?>[] getConstructors()

            Constructor<T>   getDeclaredConstructor
            Constructor<?>[] getDeclaredConstructors()
        */
        /**
         * 通过过去构造方法来 调用 newInstance 来实例化对象
         */
        /*
            Class类打点调用getConstructor（获取构造器）
            Class类打点调用getConstructors（获取所有构造器）
            通过构造器来调用newInstance 构造函数来创建实例
        */
        Constructor constructor = cla2.getConstructor(int.class,String.class);
        Object o = constructor.newInstance(12, "123");
        System.out.println(o);
        Constructor[] constructors = cla2.getConstructors(); //获取所有构造器
        for (Constructor constructor1 : constructors) {
            System.out.println(constructor1);
        }
    }

}
