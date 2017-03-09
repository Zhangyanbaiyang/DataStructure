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
	//ͷ���
	Node head;

	//��ǰ�ڵ㣬Ҳ����ĩβ�ڵ�
	Node current;
	
	private int size;
	
	private int pos = 0;// �ڵ��λ�� 
	
	//���ӽڵ�
	public void addtNode(int data){
		if(head!=null){
			current.next = new Node(data);
			current = current.next;
		}else{
			head = new Node(data);
			current = head;
		}
	}
	
	//�õ�����
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
	
	//��ӡ�б�
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
	
	//��������ĳ��ȵõ�����indexλ�õ�node  ���Ӷ�ΪO(N)
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
	
	//���ò�ֵ���ҵ����  �ҵ�����indexֵ
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
	
	//�����м�ڵ�
	public Node findMidleNode(){
		if(head==null){
			return null;
		}
		Node first = head;
		Node second = head;
		
		while(second!=null){
			//����first��һ����second������
			first = first.next;
			second = second.next.next;
		}
		
		return first;
	}
	
	//�ϲ��������������
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
		
		Node head = null;//������Ŀ�ͷ�ڵ�
		Node current = null;
		
		//��Ѱͷ���
		if(head1.data<head2.data){
			head = head1;
			current = head1;
			head1 = head1.next;
		}else{
			head = head2;
			current = head2;
			head2 = head2.next;
		}
		
		//�Ƚ�����Ľڵ�
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
		
		if(head1!=null){//֤��head2�Ѿ�������
			current.next = head1;
		}
		
		if(head2!=null){//֤��head1�Ѿ�������
			current.next = head2;
		}
		
		
		return head;
		
	}
	
	//�ж��Ƿ��л�
	public boolean isCycle(Node head){
		if(head==null){
			return false;
		}
		Node second =head;
		Node first = head;
		while(second!=null){
			first = first.next; //first��һ��
			second = second.next.next;//second������
			
			if(first.equals(second)){
				//�������ָ����ͬ��֤����ͬһ���������equal�ǻ������ж�����ͬ��
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
