package cn.zy.offer;
/**
 * @author zy
 */
public class BinaryTree {


	
	private Node root; 
	/**
	 * ?????
	 */
	
	private class Node{
		private Node left;
		private Node right;
		private int data;
		
		Node(int data){
			this.left = null;
			this.right = null;
			
			this.data = data;
		} 
	}
	
	public BinaryTree(){
		this.root = null;
	}
	
	/**
	 * ??????????
	 * @param args
	 */
	public void buildTree(Node node,int data){
		if(root == null){
			root = new Node(data);
		}else{
			if(data<node.data){
				//???????????
				if(node.left == null){
					node.left = new Node(data);
				}else{
					buildTree(node.left,data);
				}
			}else{
				//???????????
				if(node.right ==null){
					node.right = new Node(data);
				}else{
					buildTree(node.right,data);
				}
			}
		}
	}
	
	/**
	 * ??????
	 */
	public void preNode(Node node){
		if(node!=null){
			System.out.print(node.data+"-->");
			preNode(node.left);
			preNode(node.right);
		}

	}
	
	/**
	 * ???????
	 */
	public void inNode(Node node){
		if(node!=null){
			inNode(node.left);
			System.out.print(node.data+"-->");
			inNode(node.right);
		}

	}
	
	/**
	 * ???????
	 */
	public void postNode(Node node){
		if(node!=null){
			postNode(node.left);
			
			postNode(node.right);
			
			System.out.print(node.data+"-->");
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1,3,5,56,78,99,100,89,999,22,55};
		BinaryTree tree = new BinaryTree();
		for(int i=0;i<arr.length;i++){
			tree.buildTree(tree.getRoot(), arr[i]);
		}
		
		tree.preNode(tree.getRoot());
		System.out.println("??????");
		tree.inNode(tree.getRoot());
		System.out.println("???????");
		tree.postNode(tree.getRoot());
		System.out.println("???????");

		
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}
