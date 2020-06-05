package com.reflect;

import java.lang.reflect.Method;

/**
 * @ClassName: R01
 * @Description: TODO  反射机制 如何通过Class来获取对象
 * @Author: TianHongzhen
 * @Date: 2020/4/28 21:01
 */
public class R03 {
    public static void main(String[] args) throws Exception{
        /*
         3、获取成员方法
            Method   getMethod
            Method[] getMethods()  会获取所有的方法  包括 继承的父类 和 实现的接口

            Method   getDeclaredMethod
            Method[] getDeclaredMethods()

        */
        Class cla2 = Person.class;
        //获取所有的方法
        Method[] methods = cla2.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //获取方法
        Method setId = cla2.getMethod("setId", int.class);
        Method getId = cla2.getMethod("getId");
        //invoke(Object obj, Object... args)
        //在具有指定参数的 方法对象上调用此 方法对象表示的底层方法。
        setId.setAccessible(true);
        Object person = cla2.newInstance();
        setId.invoke(person,12);
        Object invoke = getId.invoke(person);
        System.out.println(invoke);
    }

}
