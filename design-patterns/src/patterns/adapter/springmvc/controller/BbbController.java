package patterns.adapter.springmvc.controller;

/**
 * @ClassName: AaaController
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 17:22
 */
public class BbbController implements Controller{
    public void doBbbHandler(){
        System.out.println("doBbbHandler...");
    }
}
