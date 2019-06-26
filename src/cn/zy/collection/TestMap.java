package cn.zy.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Title:
 * @Project:
 * @Author: zy
 * @Description:
 * @Date: Create in 10:21 2019/3/17
 */
public class TestMap {

    public static void main(String args[]){

        System.out.println(21312);


        Map treeMap = new TreeMap();

        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("","");

        BitSet bitSet = new BitSet();

       /* Set set = new HashSet();

        Set treeSet = new TreeSet();
*/
        Map map3 = new ConcurrentHashMap();

        Map map = new HashMap();


        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();



        //���� old *2+1 ԭʼ��С11
       /* Map map1 = new Hashtable<>();

        Map map3 = new ConcurrentHashMap();*/


/*
        System.out.println(10 << 1);
        System.out.println(10>>>3);

        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(20));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(10>>>3));

        int h= 0;
        System.out.print("231".hashCode());
        System.out.print(("231" == null) ? 0 : (h = "231".hashCode()) ^ (h >>> 16));

        Collections.synchronizedList(new ArrayList<>());
        //Collections.synchronizedSortedMap
        Collections.synchronizedSet(new HashSet());*/

        map.put("1",1);
        map.put("2",2);
        map.put("16",2);

        map.put("555",2);

        map.put("213123123",2);





    }

}
