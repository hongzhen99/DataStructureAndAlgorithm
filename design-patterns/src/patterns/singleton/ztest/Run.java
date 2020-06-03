package patterns.singleton.ztest;

import java.time.LocalDateTime;

/**
 * @ClassName: Run
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/11 18:16
 */
public class Run {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime==localDateTime1);

    }
}
