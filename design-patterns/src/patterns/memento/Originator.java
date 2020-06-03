package patterns.memento;

/**
 * @ClassName: Status
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/2 12:45
 */
//发起人
public class Originator {
    private String state;

    public Originator() {

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Memento save(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
