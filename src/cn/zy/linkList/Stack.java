package cn.zy.linkList;

public class Stack {
	
	private Object elements[];
	
	private int maxSize;
	//ջ��λ��
	private int top;
	
	public Stack(int maxSize){
		this.maxSize = maxSize;
		elements = new Object[maxSize];
		top = -1;
	}
	
	//�õ�ջ��Ԫ�ظ���
	public int getSize(){
		int size = top+1;
		return size;
	}
	
	//�ж��Ƿ�����
	public boolean isFull(){
		if(top==maxSize-1){
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	//�����м���Ԫ��
	public boolean push(Object t) {
		if(!isFull()){
			this.elements[++top] = t;
			return true;
		}else{
			System.out.println("ջ����");
			return false;
		}
		
	}
	
	//�������ó�Ԫ��
	public Object pop() throws Exception{
		if(isEmpty()){
			throw new Exception("ջ�Կ�");
		}
		Object t = this.elements[top];
		this.elements[top] = null;
		top--;
		return elements;
	}
	
	//����ջ��Ԫ��
	public Object peek() throws Exception{
		if(isEmpty()){
			throw new Exception("ջ�ǿ�ջ");
		}
		return this.elements[this.getSize()-1];
	}
	
	public static void main(String args[]){
		Stack s = new Stack(10);
		System.out.println(s.getSize());
		s.push(1);
		System.out.println(s.getSize());
		System.out.println();
	}
}
