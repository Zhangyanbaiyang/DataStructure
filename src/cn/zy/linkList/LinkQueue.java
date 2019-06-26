package cn.zy.linkList;

import java.util.Stack;


//ʹ������ʵ�ֶ���
public class LinkQueue {
	
	private int maxSize;
	
	private int[] queueArray;
	
	//ǰָ��
	private int front;
	
	//��ָ��
	private int rear;
	
	//Ԫ�ظ���
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
			System.out.println("���пռ�����");
			return;
		}
		
		//�������
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
