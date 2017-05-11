/**
 * 
 */
package cn.zy.JVM;

import java.util.*;



/**
 * VM args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 检测堆内存溢出
 * @author zy
 * 2017年5月8日
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
