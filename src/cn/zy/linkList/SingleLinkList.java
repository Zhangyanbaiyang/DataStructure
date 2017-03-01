package cn.zy.linkList;

public class SingleLinkList {
	
	class Node {
		
		private Node next;
		
		private int data;
		
		public Node(int data){
			this.data = data;
		} 

		public void display(){
			System.out.print(data+"  ");
		}
	}
	
	Node head;

	Node current;
	
	private int size;
	
	private int pos = 0;// 节点的位置 
	
	public void addtNode(int data){
		if(head!=null){
			current.next = new Node(data);
			current = current.next;
		}else{
			head = new Node(data);
			current = head;
		}
	}
	
	public int getLength(){
		if(head==null){
			return 0;
		}
		int length = 0;
		current = head;
		while(current!=null){
			length++;
			current = current.next;
		}
		return length;
	}
	
	public void printList(){
		if(head==null){
			return;
		}
		current = head;
		while(current!=null){
			System.out.print(current.data+"-->");
			current = current.next;
		}
	}
	
	public Node findLastIndex(int index){
		if(head==null){
			return null;
		}
		
		int length = this.getLength();
		if(index>=length){
			throw new IndexOutOfBoundsException("index out of list'length ");
		}
		current = head;
		for(int i = 0;i<size-index;i++){
			current = current.next;
		}
		return current;
	}
	
	
	
	
	
}
