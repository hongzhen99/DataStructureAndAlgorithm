package test.openclose;

/**
 * @ClassName: Test01
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/10 16:19
 */
public class Test01 {
    public static void main(String[] args) {
        User user = new User();
        user.make1(new A());
        user.make2(new B());
    }
}
class User {
    public void make1(Base base){
        base.draw1();
    }public void make2(Base1 base1){
        base1.draw2();
    }
}

abstract class Base{

    public abstract void draw1();
}
interface Base1{

    public  void draw2();
}
class A extends Base implements Base1{
    @Override
    public void draw1() {
        System.out.println("绘画三角形1");
    }

    @Override
    public void draw2() {
        System.out.println("绘画三角形2");
    }
}
class B extends Base implements Base1{

    @Override
    public void draw1() {
        System.out.println("绘画圆形1");
    }

    @Override
    public void draw2() {
        System.out.println("绘画圆形2");
    }
}