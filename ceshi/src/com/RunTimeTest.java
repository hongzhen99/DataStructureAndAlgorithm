package com;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RunTimeTest
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/27 23:18
 */
public class RunTimeTest {
    public static void main(String[] args) {
//        long maxMemory = Runtime.getRuntime().maxMemory();  //最大占用内存量
//        long min = Runtime.getRuntime().totalMemory();
//
//        System.out.println(maxMemory/(double)1024/1024+ "M");
//        System.out.println(min/(double)1024/1024+ "M");

//        List<String> strings = new ArrayList<>();
//        List<String> strings = new Vector<>();
//        List<String> strings = Collections.synchronizedList(new ArrayList<>());
//        List<String> strings = new CopyOnWriteArrayList<>();
//        for(int i =0 ;i <10 ;i++) {
//            new Thread(() -> {
//                strings.add(UUID.randomUUID().toString().substring(0, 4));
//                System.out.println(strings);
//            }, String.valueOf(i)).start();
//        }

//        HashSet set = new HashSet();
//        set.add("1");
//        set.add("2");
//        System.out.println(set);
//        Map map = new HashMap();

//        Map map = new HashMap();
//        Map map = Collections.synchronizedMap(new HashMap());
        Map map = new ConcurrentHashMap();
        for(int i =0 ;i <10 ;i++) {
            new Thread(() -> {
                map.put(UUID.randomUUID().toString().substring(0, 4),"1");
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

    }
}
