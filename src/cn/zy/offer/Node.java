package cn.zy.offer;

public class Node {
	int data;
	Node next =null;
	
	Node(int data){
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
