package patterns.state.test;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/2 23:32
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        //开始状态
        context.setState(new Begin());
        System.out.println("当前状态"+context.getState());


        context.shenHe(context);
        System.out.println("当前状态"+context.getState());

//        context.faBu(context);
//        System.out.println("当前状态"+context.getState());
    }
}
