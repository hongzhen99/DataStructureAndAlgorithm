package patterns.memento;

/**
 * @ClassName: Memento
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/2 12:49
 */
//备忘录对象
public class Memento {
    private String state;

    public Memento(String s){
        this.state = s;
    }

    public String getState() {
        return state;
    }
}
