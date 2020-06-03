package patterns.adapter.springmvc;

import patterns.adapter.springmvc.adapter.AaaAdapter;
import patterns.adapter.springmvc.adapter.BbbAdapter;
import patterns.adapter.springmvc.adapter.CccAdapter;
import patterns.adapter.springmvc.adapter.HandlerAdapter;
import patterns.adapter.springmvc.controller.AaaController;
import patterns.adapter.springmvc.controller.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DispatchServlet
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 17:20
 */
public class DispatchServlet {
    public  static List<HandlerAdapter> handlerAdapters = new ArrayList<HandlerAdapter>();

    public DispatchServlet() {
        handlerAdapters.add(new AaaAdapter());
        handlerAdapters.add(new BbbAdapter());
        handlerAdapters.add(new CccAdapter());
    }

    public void doDispatchServlet(){
        AaaController aaaController = new AaaController();
//        BbbController bbbController = new BbbController();
//        CccController cccController = new CccController();

        HandlerAdapter adapter = getAdapter(aaaController);
        adapter.handler(aaaController);

    }
    //获取适配器
    public HandlerAdapter getAdapter(Controller controller){
        //从已有的适配器里 循环挑出
        for (HandlerAdapter adapter : this.handlerAdapters){
            if (adapter.supports(controller)){
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
            new DispatchServlet().doDispatchServlet();
    }
}
