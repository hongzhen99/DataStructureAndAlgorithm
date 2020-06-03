package patterns.adapter.springmvc.adapter;

import patterns.adapter.springmvc.controller.AaaController;

/**
 * @ClassName: AaaAdapter
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 17:21
 */
public class AaaAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof AaaController);
    }

    @Override
    public void handler(Object handler) {
        ((AaaController)handler).doAaaHandler();

    }
}
