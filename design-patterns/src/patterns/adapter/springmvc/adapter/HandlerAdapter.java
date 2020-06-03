package patterns.adapter.springmvc.adapter;

/**
 * @ClassName: HandlerAdapter
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 17:21
 */
public interface HandlerAdapter {
    //判断 是否匹配对应的handler
    public boolean supports(Object handler);

    //执行
    public void handler(Object handler);
}
