package patterns.builder.type1;

/**
 * @ClassName: HightHose
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/13 19:03
 */
public class HighHose extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("高楼房子5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砖50cm");
    }

    @Override
    public void roofed() {
        System.out.println("高楼屋顶5cm");
    }
}
