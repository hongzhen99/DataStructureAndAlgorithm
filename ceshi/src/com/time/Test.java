package com.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/9 13:43
 */
public class Test {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date.toLocaleString());


        LocalDate localDate = LocalDate.now();

        LocalTime localTime = LocalTime.now();

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(localDate);
        System.out.println(localTime);
    }
}
