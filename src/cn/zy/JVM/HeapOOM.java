/**
 * 
 */
package cn.zy.JVM;

import java.util.*;



/**
 * VM args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * �����ڴ����
 * @author zy
 * 2017��5��8��
 */
public class HeapOOM {
	
	static class OOMObejct{}

	public static void main(String args[]){
		List<OOMObejct> list = new ArrayList<OOMObejct>();
		
		while(true){
			list.add(new OOMObejct());
		}
	}

}
