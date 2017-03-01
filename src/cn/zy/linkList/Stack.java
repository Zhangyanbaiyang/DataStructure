package cn.zy.linkList;

public class Stack {
	
	private Object elements[];
	
	private int maxSize;
	//栈顶位置
	private int top;
	
	public Stack(int maxSize){
		this.maxSize = maxSize;
		elements = new Object[maxSize];
		top = -1;
	}
	
	//得到栈中元素个数
	public int getSize(){
		int size = top+1;
		return size;
	}
	
	//判断是否已满
	public boolean isFull(){
		if(top==maxSize-1){
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	//往堆中加入元素
	public boolean push(Object t) {
		if(!isFull()){
			this.elements[++top] = t;
			return true;
		}else{
			System.out.println("栈以满");
			return false;
		}
		
	}
	
	//往堆中拿出元素
	public Object pop() throws Exception{
		if(isEmpty()){
			throw new Exception("栈以空");
		}
		Object t = this.elements[top];
		this.elements[top] = null;
		top--;
		return elements;
	}
	
	//返回栈顶元素
	public Object peek() throws Exception{
		if(isEmpty()){
			throw new Exception("栈是空栈");
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
