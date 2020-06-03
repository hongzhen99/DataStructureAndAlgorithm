package patterns.brideg.type1;

/**
 * @ClassName: Phone
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/15 23:27
 */
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand){
        super();
        this.brand = brand;
     
    }
    protected void open(){
        this.brand.open();
    }
    protected void close(){
        this.brand.close();
    }
    protected void call(){
        this.brand.call();
    }
}
