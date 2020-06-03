package patterns.observer;

/**
 * @ClassName: Subject
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/1 15:38
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
