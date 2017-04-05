package cn.zy.offer;
/**
 * @author zy
 */
public class BinaryTree {


	
	private Node root; 
	/**
	 * 私有类
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
	 * 构建二叉树
	 * @param args
	 */
	public void buildTree(Node node,int data){
		if(root == null){
			root = new Node(data);
		}else{
			if(data<node.data){
				//构建左二叉树
				if(node.left == null){
					node.left = new Node(data);
				}else{
					buildTree(node.left,data);
				}
			}else{
				//构建右二叉树
				if(node.right ==null){
					node.right = new Node(data);
				}else{
					buildTree(node.right,data);
				}
			}
		}
	}
	
	/**
	 * 前序遍历
	 */
	public void preNode(Node node){
		if(node!=null){
			System.out.print(node.data+"-->");
			preNode(node.left);
			preNode(node.right);
		}

	}
	
	/**
	 * 中序遍历
	 */
	public void inNode(Node node){
		if(node!=null){
			inNode(node.left);
			System.out.print(node.data+"-->");
			inNode(node.right);
		}

	}
	
	/**
	 * 后序遍历
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
		System.out.println("前序遍历");
		tree.inNode(tree.getRoot());
		System.out.println("中序遍历");
		tree.postNode(tree.getRoot());
		System.out.println("后序遍历");

		
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}
