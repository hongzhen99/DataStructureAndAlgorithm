package patterns.proxy.type2dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: ProxyFactory
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/22 14:11
 */
public class ProxyFactory {
    //传入要代理的对象  接口
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//传入当前类的类加载器  固定
                target.getClass().getInterfaces(),//传入当前类的所有接口   固定
                new InvocationHandler() {    //调用处理程序
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始代理");
                        Object res = method.invoke(target, args);//这里就是执行代理对象的方法
                        return res;
                    }
                });
    }
}
