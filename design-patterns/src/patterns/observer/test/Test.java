package patterns.observer.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/1 16:14
 */
public class Test implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o.hasChanged());
        System.out.println(arg);
    }
}
class Cli{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //建立一个 被观察者对象
        Observable observable = new Observable();
        //创建观察作者对象
        Test test = new Test();
        //将观察者放入，被观察者集合中
        observable.addObserver(test);
        //利用反射过去到Class
        Class<? extends Observable> aClass = observable.getClass();
        //获取setChanged方法
        Method setChanged = aClass.getDeclaredMethod("setChanged");
        //暴力破解 并执行此方法传入该对象
        setChanged.setAccessible(true);
        setChanged.invoke(observable);

        //通知
        observable.notifyObservers("23");
    }
}
