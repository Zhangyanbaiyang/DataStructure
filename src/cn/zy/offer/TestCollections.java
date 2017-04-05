package cn.zy.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Vector;

public class TestCollections {
	
	public static void main(String args[]){
		HashSet ss = new HashSet();
		
		ss.add(11);
		ss.add(22);
		ss.add(5);
		
		
		/*Iterator it = ss.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		
		
		ArrayList a = new ArrayList();
		a.add("1");
		a.add("2");
		a.add("3");
		
		/*Iterator it = a.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		
		Map h = new HashMap();
		h.put(1,"1");
		h.put(1, "1");
		h.put(2,"2");
		h.put(3,"3");

//		Iterator it = h.keySet().iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
		
		
		LinkedHashSet l = new LinkedHashSet();
		l.add("1");
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		
		Iterator ll = l.iterator();
		while(ll.hasNext()){
			System.out.println(ll.next());
		}
		
		System.out.println(.75f);
		
		Vector v = new Vector();
		v.add(1);
		v.add(2);
		v.add(3);
	}

}
