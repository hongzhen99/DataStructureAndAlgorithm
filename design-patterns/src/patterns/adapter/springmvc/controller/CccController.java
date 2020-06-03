package patterns.adapter.springmvc.controller;

/**
 * @ClassName: AaaController
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 17:22
 */
public class CccController implements Controller{
    public void doCccHandler(){
        System.out.println("doCccHandler...");
    }
}
