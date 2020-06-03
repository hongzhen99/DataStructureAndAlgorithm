package patterns.observer;

/**
 * @ClassName: CurrentConditions
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/1 15:40
 */
public class CurrentConditions implements Observer{
    int a;
    int b;
    int c;

    public void display(){
        System.out.println(""+a+"");
        System.out.println(""+b+"");
        System.out.println(""+c+"");
    }

    @Override
    public void update(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.display();
    }
}
