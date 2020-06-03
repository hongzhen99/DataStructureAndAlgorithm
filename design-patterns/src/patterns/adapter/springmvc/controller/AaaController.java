package patterns.adapter.springmvc.controller;

/**
 * @ClassName: AaaController
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 17:22
 */
public class AaaController implements Controller{
    public void doAaaHandler(){
        System.out.println("doAaaHandler...");
    }
}
