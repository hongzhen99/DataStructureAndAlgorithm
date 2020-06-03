package patterns.builder.type1;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/13 19:15
 */
public class Client {
    public static void main(String[] args) {
        CommonHose commonHose = new CommonHose();

        HouseDirector houseDirector = new HouseDirector();

        houseDirector.setHouseBuilder(commonHose);

        House house = houseDirector.creatHose();

        System.out.println(house);
    }
}
