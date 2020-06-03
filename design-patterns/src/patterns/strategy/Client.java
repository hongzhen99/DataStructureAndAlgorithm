package patterns.strategy;

import patterns.strategy.duixiang.BigPlane;
import patterns.strategy.duixiang.PaperPlane;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/3 15:42
 */
public class Client {
    public static void main(String[] args) {
//        //纸飞机
//        PaperPlane paperPlane = new PaperPlane();
//        paperPlane.fly();
//
//        //大飞机
//        BigPlane bigPlane = new BigPlane();
//        bigPlane.fly();

        Integer[] aaa = {2,4,6,8,1,3};

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if((Integer)o1 > (Integer)o2){
                    return 1;
                }else {
                    return -1;
                }
            }
        };

//        Arrays.sort(aaa,(var1,var2) -> {
//            if (var1.compareTo(var2)>0) {
//                return 1;
//            }else {
//                return -1;
//            }
//        });
        Arrays.sort(aaa,null);
        System.out.println(Arrays.toString(aaa));
    }
}
