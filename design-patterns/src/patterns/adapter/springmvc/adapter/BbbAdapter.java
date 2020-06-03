package patterns.adapter.springmvc.adapter;

import patterns.adapter.springmvc.controller.BbbController;

/**
 * @ClassName: AaaAdapter
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 17:21
 */
public class BbbAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof BbbController);
    }

    @Override
    public void handler(Object handler) {
        ((BbbController)handler).doBbbHandler();
    }
}
