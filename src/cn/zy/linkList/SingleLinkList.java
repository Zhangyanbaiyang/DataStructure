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
	//头结点
	Node head;

	//当前节点，也就是末尾节点
	Node current;
	
	private int size;
	
	private int pos = 0;// 节点的位置 
	
	//增加节点
	public void addtNode(int data){
		if(head!=null){
			current.next = new Node(data);
			current = current.next;
		}else{
			head = new Node(data);
			current = head;
		}
	}
	
	//得到长度
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
	
	//打印列表
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
	
	//利用链表的长度得到倒数index位置的node  复杂度为O(N)
	/*public Node findLastIndex(int index){
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
	}*/
	
	//利用差值法找到落差  找到倒数index值
	public Node findLastIndex(int index){
		if(head==null||index==0){
			return null;
		}
		
		Node first = head;
		Node second = head;
		
		for(int i = 0;i<index;i++){
			second = second.next;
		}
		
		while(second!=null){
			first = first.next;
			second = second.next;
		}
		return first;
	}
	
	//查找中间节点
	public Node findMidleNode(){
		if(head==null){
			return null;
		}
		Node first = head;
		Node second = head;
		
		while(second!=null){
			//利用first走一步，second走两步
			first = first.next;
			second = second.next.next;
		}
		
		return first;
	}
	
	//合并两个有序的链表
	public Node mergeLinkList(Node head1,Node head2){
		if(head1==null&&head2==null){
			return null;
		}
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		
		Node head = null;//新链表的开头节点
		Node current = null;
		
		//找寻头结点
		if(head1.data<head2.data){
			head = head1;
			current = head1;
			head1 = head1.next;
		}else{
			head = head2;
			current = head2;
			head2 = head2.next;
		}
		
		//比较下面的节点
		while(head1!=null&&head2!=null){
			if(head1.data<head2.data){
				current.next = head1;
				current = current.next;
				head1 = head1.next;
			}else{
				current.next = head2;
				current = current.next;
				head2 = head2.next;
			}
		}
		
		if(head1!=null){//证明head2已经遍历完
			current.next = head1;
		}
		
		if(head2!=null){//证明head1已经遍历完
			current.next = head2;
		}
		
		
		return head;
		
	}
	
	//判断是否有环
	public boolean isCycle(Node head){
		if(head==null){
			return false;
		}
		Node second =head;
		Node first = head;
		while(second!=null){
			first = first.next; //first走一步
			second = second.next.next;//second走两步
			
			if(first.equals(second)){
				//如果两者指针相同则证明是同一对象，如果是equal是还不能判断其相同。
				return true;
			}
		}
		
		return false;
		
	}
	
	
	
	
	
	public static void main(String args[]){
		SingleLinkList s = new SingleLinkList();
		Node node1 = s.new Node(2);
		Node node2 = s.new Node(2);
		System.out.println(node1.equals(node2));
	}
	
	
	
	
	
	
	
}
