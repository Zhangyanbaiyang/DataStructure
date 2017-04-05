package cn.zy.linkList;

import java.util.Stack;


//使用数组实现队列
public class LinkQueue {
	
	private int maxSize;
	
	private int[] queueArray;
	
	//前指针
	private int front;
	
	//后指针
	private int rear;
	
	//元素个数
	private int size;
	
	public LinkQueue(int s){
		
		queueArray = new int[s];
		
		maxSize = s;
		
		front = 0;
		
		rear = -1;
				
		size = 0;	
	}
	
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		return false;
	}
	
	public boolean isFull(){
		if(maxSize==size){
			return true;
		}
		return false;
		
	}
	
	public void insert(int s){
		if(isFull()){
			System.out.println("队列空间已满");
			return;
		}
		
		//避免出现
		if(rear==maxSize-1){
			rear=-1;
		}
		
		queueArray[++rear] = s;
		
		size++;		
		
	}
	
	public int remove(){
		
		int temp = queueArray[front++];
		
		if(front==maxSize){
			front = 0;
		}
		
		size--;
		return temp;
	}
	
	public int size(){
		return size;
	}
	
	
}
