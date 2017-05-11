/**
 * 
 */
package cn.zy.JVM;

/**
 * 利用递归造成栈内存溢出
 * VM args -Xss128K
 * @author zy
 * 2017年5月8日
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;

	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.out.println("stack length :"+oom.stackLength);
			throw e;
		}
		

	}

}
