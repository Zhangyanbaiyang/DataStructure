package cn.zy.linkList;

public class QueueList {

	/**
	 * 链表实现队列
	 */
	
	class Node{
		Node next;
		
		Object data;
		
		public Node(Object data){
			this.data = data;
		}
	}
	
	//首节点
	private Node head;
	
	//后指针后节点
	private Node rear;
	
	//队列拥有元素个数
	private int size;
	
	public QueueList(){
		head = rear =null;
		
		size  = 0;
	}
	
	 public int getSize(){
	      return size;
	 }
	 
	 public void push(Object o){
		 Node newNode = new Node(o);
		 if(this.getSize()==0){
			
			 rear = newNode;
			 head = rear;
		 }else{
			 rear.next = newNode;
			 rear =  rear.next;
		 }
		 size++;
	 }

	 public Object pop(){
		 if(getSize()==0){
			 System.out.println("队列易控");
			 return null;
		 }
		 Object o = head.data;
		 head = head.next;
		 size--;
		 
		return o;
		 
	 }
	
	public static void main(String[] args) {
		 QueueList q = new QueueList();  
	        q.push("张三");  
	        q.push("李斯");  
	        q.push("赵五");  
	        q.push("王一"); 
	        for(int i=0;i<4;i++){
	        	System.out.println(q.pop());
	        }
	}

}
