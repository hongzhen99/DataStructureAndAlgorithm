package patterns.state.test;

/**
 * @ClassName: Context
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/2 23:22
 */
public class Context extends AbstractState{
    private State state;

    @Override
    public void begin(Context context) {
        state.begin(this);
    }

    @Override
    public void shenHe(Context context) {
        state.shenHe(this);
    }

    @Override
    public void faBu(Context context) {
        state.faBu(this);
    }

    @Override
    public void end(Context context) {
        state.end(this);
    }


    public State getState1() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    @Override
    public String getState() {
        return state.getState();
    }
}
