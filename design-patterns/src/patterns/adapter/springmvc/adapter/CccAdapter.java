package patterns.adapter.springmvc.adapter;

import patterns.adapter.springmvc.controller.CccController;

/**
 * @ClassName: AaaAdapter
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 17:21
 */
public class CccAdapter implements HandlerAdapter{

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof CccController);
    }

    @Override
    public void handler(Object handler) {
        ((CccController)handler).doCccHandler();
    }
}
