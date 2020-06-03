package patterns.state.test;

/**
 * @ClassName: State
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/2 23:12
 */
public interface State {

    void begin(Context context);

    void shenHe(Context context);

    void faBu(Context context);

    void end(Context context);

    String getState();
}
