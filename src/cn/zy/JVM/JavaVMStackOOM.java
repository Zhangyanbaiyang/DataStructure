/**
 * 
 */
package cn.zy.JVM;

/**
 * vm args :-Xss2M  �����ջ�ڴ�
 * ���߳���ɵ����ڴ�����쳣����
 * @author zy
 * 2017��5��8��
 */
public class JavaVMStackOOM {

	private void dontStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		
		// TODO Auto-generated method stub
				while(true){
					Thread thread = new Thread(new Runnable() {
						
						@Override
						public void run() {
							
							dontStop();
						}
					});
					thread.start();
				}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
