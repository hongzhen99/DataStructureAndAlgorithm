package patterns.builder.type1;

/**
 * @ClassName: HouseBuilder
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/13 18:58
 */
public abstract class HouseBuilder {

    House house = new House();

    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    public House builderHose(){
        return house;
    }
}
