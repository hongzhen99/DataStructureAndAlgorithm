package patterns.decorator.type1.drink;

/**
 * @ClassName: Drink
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 0:08
 */
public abstract class Drink {

    private String des ;//描述
    private float price = 0.0f;//价格

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
