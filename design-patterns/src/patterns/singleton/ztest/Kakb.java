package patterns.singleton.ztest;


/**
 * @ClassName: Kakb
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 10:42
 */
public class Kakb {
    public static void main(String[] args) {
        Integer a = 1;//相当于new 一个新对象
        Integer b = Integer.valueOf(1);

        int c = 1000;
        int d = 1000;

        System.out.println(a==b);
        System.out.println(c==d);
    }
}
