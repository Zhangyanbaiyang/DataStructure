/**
 * 
 */
package cn.zy.JVM;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * ���� Unsafe��
 * @author zy
 * 2017��5��9��
 */
public class TestUnSafe {

	
	public static void main(String[] args) throws Exception {
			
		Field f = Unsafe.class.getDeclaredField("theUnsafe");		
		f.setAccessible(true); 		
		
		Unsafe unsafe = (Unsafe) f.get(null);
		
		/*
		 * Field
		 *public Object get(Object obj)
           throws IllegalArgumentException,
                  IllegalAccessException����ָ�������ϴ� Field ��ʾ���ֶε�ֵ�������ֵ��һ����������ֵ�����Զ������װ��һ�������С� 
�ײ��ֶε�ֵ�ǰ����·�ʽ��õģ� 

����ײ��ֶ���һ����̬�ֶΣ������ obj ������������Ϊ null�� 

���򣬵ײ��ֶ���һ��ʵ���ֶΡ����ָ���� obj ����Ϊ null����÷������׳�һ�� NullPointerException�����ָ�������������ײ��ֶε����ӿڵ�ʵ������÷������׳�һ�� IllegalArgumentException�� 

����� Field ����ǿ��ʵʩ Java ���Է��ʿ��ƣ����ҵײ��ֶ��ǲ��ɷ��ʵģ���÷������׳�һ�� IllegalAccessException������ײ��ֶ��Ǿ�̬�ģ������������ֶε�����δ��ʼ�������ʼ������ࡣ 

���򣬴ӵײ�ʵ���ֶλ�̬�ֶ��л�ȡ��ֵ��������ֶ���һ�����������ֶΣ����ڷ���ǰ����ֵ��װ��һ�������У�������ԭ�����ء� 

����ֶ������� obj �������У������ǰ��Ĺ������ֶε�ֵ�� 
		 */
		
		
		Player p = (Player) unsafe.allocateInstance(Player.class);	
		System.out.println(p.getAge());
		p.setAge(555);
		System.out.println(p.getAge());
		
		String password = new String("l00k@myHor$e"); 
		String fake = new String(password.replaceAll(".", "?"));
		System.out.println(password);
		System.out.println(fake);
		
//		unsafe.getUnsafe().copyMemory(fake, 0L, null, unsafe.toAddress(password), unsafe.sizeOf(password));
	}

	class Player{
		
		private int age;
		
		public Player(){
			this.age = 50;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		
		
		
	}
}
