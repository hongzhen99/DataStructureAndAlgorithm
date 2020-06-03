package patterns.adapter.objadapter;

/**
 * @ClassName: Phone
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 16:12
 */
public class Phone {
    public void charging(Voltage5V v){
        if(v.out5v()==5){
            System.out.println("电压为5V,可以充电");
        }else {
            System.out.println("电压不正确");
        }
    }
}
