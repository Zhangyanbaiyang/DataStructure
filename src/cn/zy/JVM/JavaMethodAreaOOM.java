/**
 * 
 */
package cn.zy.JVM;

import java.lang.reflect.Method;

import cn.zy.JVM.HeapOOM.OOMObejct;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 方法区内存
 * vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author zy
 * 2017年5月8日
 */
public class JavaMethodAreaOOM {

	
	public static void main(String[] args) {
		while(true){
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObejct.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				
				@Override
				public Object intercept(Object arg0, Method arg1, Object[] arg2,
						MethodProxy arg3) throws Throwable {
					// TODO Auto-generated method stub
					return arg3.invokeSuper(arg1, arg2);
				}
			});
			
			enhancer.create();
		}

	}

}
