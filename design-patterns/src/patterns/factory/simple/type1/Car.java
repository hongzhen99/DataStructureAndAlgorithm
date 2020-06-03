package patterns.factory.simple.type1;

/**
 * @ClassName: Car
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 18:48
 */
class Car implements Product{
    public Car(){
        System.out.println("汽车被制造了");
    }
}
class Air implements Product {
    public Air(){
        System.out.println("Air被创造了");
    }
}
class Tv implements Product{
    public Tv(){
        System.out.println("电视被制造了");
    }
}