package com.reflect;

import java.lang.reflect.Field;

/**
 * @ClassName: R01
 * @Description: TODO  反射机制 如何通过Class来获取对象
 * @Author: TianHongzhen
 * @Date: 2020/4/28 21:01
 */
public class R01 {
    public static void main(String[] args) throws Exception{
        /*
            1、通过Class.forName来获取
            System.out.println(cla1); class com.replace.Person
            System.out.println(cla2);
            System.out.println(cla3);
         */
        Class cla1 = Class.forName("com.reflect.Person");
        //2、通过类名.class
        Class cla2 = Person.class;
        //3、通过对象 .getClass来获取
        Person person = new Person();
        Class cla3 = person.getClass();

        //确定是获取同一个对象
        //System.out.println(cla1==cla2);  true
        //System.out.println(cla2==cla3);  true
        /*
            Class对象的获取功能
                1、获取成员变量
                    Field   getField(String name)  获取指定public变量修饰的成员变量的名字
                    Field[] getFields()     获取所有public修饰的成员

                    setAccessible(true); //暴力反射 访问私有变量
                    Field getDeclaredField(String name)
                    Field[] getDeclaredFields() 获取所有成员变量 不考虑修饰
                2、获取构造方法符
                    Constructor<T>   getConstructor
                    Constructor<?>[] getConstructors()

                    Constructor<T>   getDeclaredConstructor
                    Constructor<?>[] getDeclaredConstructors()
                3、获取成员方法
                    Method   getMethod
                    Method[] getMethods()

                    Method   getDeclaredMethod
                    Method[] getDeclaredMethods()
                4、获取类名
                    String getName()
        */
        Field[] f  = cla1.getDeclaredFields();
        for (Field field : f) {
            System.out.println(field);
        }
        Field name = cla1.getDeclaredField("name");
        name.setAccessible(true);


        name.set(person,"哈哈哈");
        Object o = name.get(person);
        System.out.println(o);
    }

}
