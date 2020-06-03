package patterns.brideg.type2ceshijdbc;

import patterns.brideg.type2ceshijdbc.sql.Driver;

/**
 * @ClassName: DriverManage
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/16 0:30
 */
public class DriverManage {

    public static void  registerDriver(Driver driver){
        System.out.println("已注册");
    }

    public static void main(String[] args) {
        try {
            Class.forName("patterns.brideg.type2ceshijdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        DriverManage driverManage = new DriverManage();
//        driverManage.registerDriver();
    }
}
