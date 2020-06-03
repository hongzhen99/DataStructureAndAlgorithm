package patterns.state.test;

/**
 * @ClassName: Begin
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/2 23:15
 */
public class Begin extends AbstractState{
    @Override
    public void shenHe(Context context) {
        System.out.println("进入审核");
        context.setState(new ShenHe());
    }

    @Override
    public String getState() {
        return StateEnum.BEGIN.getValue();
    }
}




class ShenHe extends AbstractState{
    @Override
    public void faBu(Context context) {
        System.out.println("进入发布状态");
        context.setState(new FaBu());
    }
    @Override
    public String getState() {
        return StateEnum.SHENHE.getValue();
    }
}
class FaBu extends AbstractState{
    @Override
    public void end(Context context) {
        System.out.println("结束");
        context.setState(new End());
    }
    @Override
    public String getState() {
        return StateEnum.FABU.getValue();
    }
}
class End extends AbstractState{
    @Override
    public void end(Context context) {
        System.out.println("以结束");
    }

    @Override
    public String getState() {
        return StateEnum.END.getValue();
    }
}