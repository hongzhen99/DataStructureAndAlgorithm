package patterns.brideg.type2ceshijdbc;

/**
 * @ClassName: Driver
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/16 0:32
 */
public class Driver implements patterns.brideg.type2ceshijdbc.sql.Driver {
    static {
        DriverManage.registerDriver(new Driver());
    }
}
