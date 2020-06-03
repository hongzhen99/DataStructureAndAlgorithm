package patterns.builder.type1;

/**
 * @ClassName: HouseDirector
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/13 19:05
 */
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    public HouseBuilder getHouseBuilder() {
        return houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House creatHose(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.builderHose();
    }
}
