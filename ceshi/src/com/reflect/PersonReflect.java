package com.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName: PersonReflact
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/28 22:31
 */
public class PersonReflect {
    public static void main(String[] args) throws Exception {
        method();
    }
    public static void method() throws Exception{
        //创建加载配置文件的对象
        Properties properties = new Properties();
        //获得类加载器  才能获得properties文件
        ClassLoader classLoader = PersonReflect.class.getClassLoader();
        //通过类加载器 调用getResourceAsStream方法 来获取 读取配置文件的输入流
        InputStream is = classLoader.getResourceAsStream("stu.properties");
        // 用该对象 加载配置文件的输入流
        properties.load(is);
        //接受配置文件中的值
        String clazz = properties.getProperty("className");
        String meth = properties.getProperty("methodName");
        //加载类到内存
        Class aClass = Class.forName(clazz);
        //创建对象
        Object o = aClass.getConstructor().newInstance();
        //获取指定的方法
        Method method = aClass.getMethod(meth);
        //执行
        method.invoke(o);
    }
}
