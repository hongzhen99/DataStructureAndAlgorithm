package patterns.observer;

import java.util.ArrayList;

/**
 * @ClassName: WeatherUpdate
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/1 15:44
 */
public class WeatherData implements Subject{

    int a;
    int b;
    int c;
    ArrayList<Observer> observers;

    public WeatherData(){
        observers = new ArrayList<>();
    }
    //更新数据
    public void setData(int a,int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
        dataChange();
    }
    public void dataChange(){
        notifyObserver();
    }
    //添加观察者
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    //通知
    @Override
    public void notifyObserver() {
        //遍历所有观察者并通知
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(a,b,c);
        }
    }
}
