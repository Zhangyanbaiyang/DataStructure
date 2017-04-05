package cn.zy.linkList;

public class QueueList {

	/**
	 * ����ʵ�ֶ���
	 */
	
	class Node{
		Node next;
		
		Object data;
		
		public Node(Object data){
			this.data = data;
		}
	}
	
	//�׽ڵ�
	private Node head;
	
	//��ָ���ڵ�
	private Node rear;
	
	//����ӵ��Ԫ�ظ���
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
			 System.out.println("�����׿�");
			 return null;
		 }
		 Object o = head.data;
		 head = head.next;
		 size--;
		 
		return o;
		 
	 }
	
	public static void main(String[] args) {
		 QueueList q = new QueueList();  
	        q.push("����");  
	        q.push("��˹");  
	        q.push("����");  
	        q.push("��һ"); 
	        for(int i=0;i<4;i++){
	        	System.out.println(q.pop());
	        }
	}

}
