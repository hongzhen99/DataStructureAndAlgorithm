package suanfa.type10hafumantree;

import java.util.*;

/**
 * @ClassName: T
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/4 22:07
 */
public class MapSortByValue {
    public static void main(String[] args) {
        String str = "i like you because you are very cute";
        Map<Character, Integer> hashMap = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            if (hashMap.containsKey(c1)) {
                int old = hashMap.get(c1);
                hashMap.put(c1, old + 1);
            } else {
                hashMap.put(c1, 1);
            }
        }
        /*
           要实现 将map中的value 升序排列
         */
        //这里将转换 map.entrySet()存入list
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hashMap.entrySet());

        //升序排序  内部排序
        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Character, Integer> mapping : list) {
            System.out.print(mapping.getKey() + ":" + mapping.getValue() + "  ");
        }

    }
}
