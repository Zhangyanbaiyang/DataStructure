package cn.zy.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title:
 * @Project:
 * @Author: zy
 * @Description:
 * @Date: Create in 8:52 2019/4/1
 */
public class TestBigData {


    public static void  main(String args[]){
        hashMapTest();
    }

    public static void hashMapTest(){
        long star = System.currentTimeMillis();

        Set<Integer> hashset = new HashSet<>(100) ;
        for (int i = 0; i < 100000000; i++) {
            hashset.add(i) ;
        }

        System.out.print(hashset.contains(200));

        long end = System.currentTimeMillis();
        System.out.println("Ö´ÐÐÊ±¼ä£º" + (end - star));
    }
}
