package patterns.builder.type1;

/**
 * @ClassName: CommonHose
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/13 19:02
 */
public class CommonHose extends HouseBuilder{
    @Override
    public void buildBasic() {
        house.setBasic("普通房子5米");
        System.out.println("普通房子5米");
    }

    @Override
    public void buildWalls() {
        house.setWall("普通砖50cm");
        System.out.println("普通砖50cm");
    }

    @Override
    public void roofed() {
        house.setRoofed("普通屋顶5cm");
        System.out.println("普通屋顶5cm");
    }
}
