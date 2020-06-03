package patterns.observer;

import java.util.Observable;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/1 15:51
 */
public class Client {
    public static void main(String[] args) {
        //创建一个weatherData
        WeatherData weatherData = new WeatherData();

        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        //注册观察者
        weatherData.registerObserver(currentConditions);
        weatherData.setData(1,2,3);
    }
}
