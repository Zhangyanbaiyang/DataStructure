package cn.zy.offer;

/**
 * @Title: ƽ�ܶ�����
 * @Project:
 * @Author: zy
 * @Description:
 * @Date: Create in 18:43 2019/3/17
 */
public class SearchBinaryTree  {

    static class Node{
        Node parent;
        Node leftChild;
        Node rightChild;
        int val;
        public Node(Node parent, Node leftChild, Node rightChild,int val) {
            super();
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.val = val;
        }

        public Node(int val){
            this(null,null,null,val);
        }

        public Node(Node node,int val){
            this(node,null,null,val);
        }

    }

    private Node root;
    private int size;
    public SearchBinaryTree() {
        super();
    }


    /**
     * �ݹ�汾����
     * @param val
     * @return
     */
    public boolean add(int val){
        if(root == null){
            root = new Node(val);
            size++;
            return true;
        }
        Node node = getAdapterNode(root, val);
        Node newNode = new Node(val);
        if(node.val > val){
            node.leftChild = newNode;
            newNode.parent = node;
        }else if(node.val < val){
            node.rightChild = newNode;
            newNode.parent = node;
        }else{
            // �ݲ�������
        }
        size++;
        return true;
    }

    /**
     * ��ȡҪ����Ľڵ�ĸ��ڵ㣬�ø��ڵ��������¼���״̬֮һ
     *  1�����ڵ�Ϊ�ӽڵ�
     *  2������ڵ�ֵ�ȸ��ڵ�С�������ڵ�û�����ӽڵ�
     *  3������ڵ�ֵ�ȸ��ڵ�󣬵����ڵ�û�����ӽڵ�
     *  4������ڵ�ֵ�͸��ڵ���ȡ�
     *  5�����ڵ�Ϊ��
     *  �����������5�����֮һ����ݹ�ֹͣ��
     * @param node
     * @param val
     * @return
     */
    private Node getAdapterNode(Node node,int val){
        if(node == null){
            return node;
        }
        // ���������в��룬��û���������򷵻�
        if(node.val > val && node.leftChild == null){
            return node;
        }
        // ���������в��룬��û��������Ҳ����
        if(node.val < val && node.rightChild == null){
            return node;
        }
        // �ýڵ���Ҷ�ӽڵ㣬�򷵻�
        if(node.leftChild == null && node.rightChild == null){
            return node;
        }

        if(node.val > val && node.leftChild != null){
            return getAdapterNode(node.leftChild, val);
        }else if(node.val < val && node.rightChild != null){
            return getAdapterNode(node.rightChild, val);
        }else{
            return node;
        }
    }

    /**
     * �����汾����
     * @param val
     * @return
     */
    public boolean put(int val){
        return putVal(root,val);
    }
    private boolean putVal(Node node,int val){
        if(node == null){// ��ʼ�����ڵ�
            node = new Node(val);
            root = node;
            size++;
            return true;
        }
        Node temp = node;
        Node p;
        int t;
        /**
         * ͨ��do whileѭ��������ȡ��ѽڵ㣬
         */
        do{
            p = temp;
            t = temp.val-val;
            if(t > 0){
                temp = temp.leftChild;
            }else if(t < 0){
                temp = temp.rightChild;
            }else{
                temp.val = val;
                return false;
            }
        }while(temp != null);
        Node newNode = new Node(p, val);
        if(t > 0){
            p.leftChild = newNode;
        }else if(t < 0){
            p.rightChild = newNode;
        }
        size++;
        return true;
    }

    /**
     * �߼�ɾ���ڵ�
     * @param val
     * @return
     */
    public boolean delete(int val){
        Node node = getNode(val);
        if(node == null){
            return false;
        }
        Node parent = node.parent;
        Node leftChild = node.leftChild;
        Node rightChild = node.rightChild;
        //�������и��ڵ�Ϊ�յ�����������ɾ���Ľڵ��Ǹ��ڵ�
        if(leftChild == null && rightChild == null){//û���ӽڵ�
            if(parent != null){
                if(parent.leftChild == node){
                    parent.leftChild = null;
                }else if(parent.rightChild == node){
                    parent.rightChild = null;
                }
            }else{//�����ڸ��ڵ㣬�����ɾ���ڵ�Ϊ���ڵ�
                root = null;
            }
            node = null;
            return true;
        }else if(leftChild == null && rightChild != null){// ֻ���ҽڵ�
            if(parent != null && parent.val > val){// ���ڸ��ڵ㣬��nodeλ��Ϊ���ڵ�����
                parent.leftChild = rightChild;
            }else if(parent != null && parent.val < val){// ���ڸ��ڵ㣬��nodeλ��Ϊ���ڵ���ұ�
                parent.rightChild = rightChild;
            }else{
                root = rightChild;
            }
            node = null;
            return true;
        }else if(leftChild != null && rightChild == null){// ֻ����ڵ�
            if(parent != null && parent.val > val){// ���ڸ��ڵ㣬��nodeλ��Ϊ���ڵ�����
                parent.leftChild = leftChild;
            }else if(parent != null && parent.val < val){// ���ڸ��ڵ㣬��nodeλ��Ϊ���ڵ���ұ�
                parent.rightChild = leftChild;
            }else{
                root = leftChild;
            }
            return true;
        }else if(leftChild != null && rightChild != null){// �����ӽڵ㶼����
            Node successor = getSuccessor(node);// ���������һ�����ں�̽ڵ�
            int temp = successor.val;
            boolean delete = delete(temp);
            if(delete){
                node.val = temp;
            }
            successor = null;
            return true;
        }
        return false;
    }

    /**
     * node ��̽ڵ㼰���������������һ���ڵ�
     * node  ����
     * ǰ�����   ���ڵ�-->��ڵ�--> �ҽڵ�
     * �������   ��ڵ�-->���ڵ�--> �ҽڵ�
     * �������   ��ڵ�--> �ҽڵ�-->���ڵ�

     *
     * �ҵ�node�ڵ�ĺ�̽ڵ�
     * 1�����жϸýڵ���û��������������У�����ҽڵ����������Ѱ�Һ�̽ڵ㣬û���������һ��
     * 2�����Ҹýڵ�ĸ��ڵ㣬���ø��ڵ���ҽڵ���ڸýڵ㣬�����Ѱ�Ҹ��ڵ㣬
     *   ֱ�����ڵ�ΪNull���ҵ������ڸýڵ���ҽڵ㡣
     * ���ɣ���̽ڵ�һ���ȸýڵ�������������������̽ڵ�һ�������������У����ǵ�һ��������
     *      ������������������Ҳ���ܴ��ڸýڵ��ĳ���游�ڵ�(���ýڵ�ĸ��ڵ㣬����ϲ㸸�ڵ�)���������У�
     *      ����������ң����У��򷵻ظýڵ㣬û���򷵻�null
     * @param node
     * @return
     */
    private Node getSuccessor(Node node){
        if(node.rightChild != null){
            Node rightChild = node.rightChild;
            while(rightChild.leftChild != null){
                rightChild = rightChild.leftChild;
            }
            return rightChild;
        }
        Node parent = node.parent;
        while(parent != null && (node == parent.rightChild)){
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    /**
     * ���ҽ��
     * @param val
     * @return
     */
    public Node getNode(int val){
        Node temp = root;
        int t;
        do{
            t = temp.val-val;
            if(t > 0){
                temp = temp.leftChild;
            }else if(t < 0){
                temp = temp.rightChild;
            }else{
                return temp;
            }
        }while(temp != null);
        return null;
    }


    /**
     * ����������
     */
    public void print(){
        print(root);
    }
    private void print(Node root){
        if(root != null){
            print(root.leftChild);
            System.out.println(root.val);// λ�����м䣬����������ǰ�棬��Ϊ���򣬷���Ϊ����
            print(root.rightChild);
        }
    }


}
