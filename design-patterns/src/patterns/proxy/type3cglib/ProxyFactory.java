package patterns.proxy.type3cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.rmi.runtime.Log;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * @ClassName: ProxyFactory
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/22 19:47
 */
public class ProxyFactory implements MethodInterceptor {
    //维护的目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }
    //返回一个代理对象   是target的代理对象
    public Object GetProxyInstance(){
        //1、创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2设置父类
        enhancer.setSuperclass(target.getClass());
        //3、设置回调
        enhancer.setCallback(this);
        //4、创建代理对象
        return enhancer.create();
    }

    //此方法会调用目标对象的方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始cglib代理");
        Object invoke = method.invoke(target, objects);
        System.out.println("cglib代理完成");
        return invoke;
    }
}
