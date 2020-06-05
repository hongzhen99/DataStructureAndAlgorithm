package com.jvm;

/**
 * @ClassName: CodeClass
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/29 22:03
 */
/*
        jvm语法规定:
        1、static代码块 > 代码块 > 构造方法
        2、static只加载一次
        输出结果:
            我是CodeClass的static代码块
            ===begin===
            我是Code01的static代码块
            我是Code01的代码块
            我是Code01的无参构造
            -------------------------------------
            我是Code01的代码块
            我是Code01的无参构造
            -------------------------------------
            我是CodeClass的代码块
            我是CodeClass的无参构造
*/
class Code01{
    static {
        System.out.println("我是Code01的static代码块");
    }
    {
        System.out.println("我是Code01的代码块");
    }
    public Code01(){
        System.out.println("我是Code01的无参构造");
    }
}
public class CodeClass {
    static {
        System.out.println("我是CodeClass的static代码块");
    }
    {
        System.out.println("我是CodeClass的代码块");
    }
    public CodeClass(){
        System.out.println("我是CodeClass的无参构造");
    }
    public static void main(String[] args) {
        System.out.println("===begin===");
        new Code01();
        System.out.println("-------------------------------------");
        new Code01();
        System.out.println("-------------------------------------");
        new CodeClass();
    }
}

