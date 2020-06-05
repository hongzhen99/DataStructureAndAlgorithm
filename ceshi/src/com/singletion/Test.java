package com.singletion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/14 18:16
 */
public class Test {
    public static void main(Singleton[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate=>"+localDate);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println("第"+localDate.getDayOfYear());
        System.out.println("=================");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println(localDateTime);


    }
}
