package cn.zy.offer;

import jdk.nashorn.internal.ir.BinaryNode;

/**
 * @Title: ƽ������� AVL
 * ����: �ڵ�����������߶Ȳ���� 1 ��С�ڵ���1��
 * �ѵ㣺������ת LL RR LR RL
 * LL : ������ת ��������ת�� �龰 �²���ڵ�������������Ҷ�ӽڵ� ���¸߶Ȳ��������
 * ע��� ��ת�� ��ĳ�Ϊ�¸��ڵ�������� ԭ����������� ��Ϊ��ת���������
 *
 * RR : ���ҵ���ת ��������ת�� �龰 �²���ڵ�������������Ҷ�ӽڵ� ���¸߶Ȳ��������
 *
 * LR : ���ҵ���ת �����������ת�� �龰 �²���ڵ�������������Ҷ�ӽڵ� ���¸߶Ȳ�������⣬�������
 * �Ƚ��������� ���²���� �ڵ��������ת Ȼ���ٽ����ڵ����µ���������������
 *
 * RL : ������ת �����Һ�����ת�� �龰 �²���ڵ�������������Ҷ�ӽڵ� ���¸߶Ȳ��������
 * �Ƚ��������� ���²���� �ڵ��������ת Ȼ���ٽ����ڵ����µ���������������

 *
 *
 * @Project:
 * @Author: zy
 * @Description:
 * @Date: Create in 21:51 2019/3/19
 */
public class AVLTree <T extends Comparable> {


    public AVLNode<T> root;


    class AVLNode<T extends Comparable> {

        public AVLNode<T> left;

        public AVLNode<T> right;

        public T data;

        public int height;//��ǰ���ĸ߶�

        public AVLNode(T data) {
            this(null,null,data);
        }

        public AVLNode(AVLNode<T> left, AVLNode<T> right, T data) {
            this(left,right,data,0);
        }

        public AVLNode(AVLNode<T> left, AVLNode<T> right, T data, int height) {
            this.left=left;
            this.right=right;
            this.data=data;
            this.height = height;
        }

    }


    int height(AVLNode<T> root) {
        if(root == null) {
            return 0;
        } else {
            return Math.max(height(root.left),height(root.right)) + 1;
        }
    }

    /**
     * ������ת(LL��ת) w��Ϊx�ĸ����, x��Ϊw��������
     *
     * LL
     * @param x
     * @return
     */
    private AVLNode<T> singleRotateLeft(AVLNode<T> x){
        //��w�����תΪ�����
        AVLNode<T> w=  x.left;
        //ͬʱw����������Ϊx��������
        x.left=w.right;
        //x��Ϊw��������
        w.right=x;
        //���¼���x/w�ĸ߶�
        x.height=Math.max(height(x.left),height(x.right))+1;
        w.height=Math.max(height(w.left),x.height)+1;
        return w;//�����µĸ����
    }

    /**
     * RR
     * ���ҵ���ת(RR��ת) x��Ϊw�ĸ����, w��Ϊx��������
     * @return
     */
    private AVLNode<T> singleRotateRight(AVLNode<T> w){

        AVLNode<T> x=w.right;

        w.right=x.left;
        x.left=w;

        //���¼���x/w�ĸ߶�
        w.height=Math.max(height(w.left),height(w.right))+1;
        x.height=Math.max(height(x.left),w.height)+1;

        //�����µĸ����
        return x;
    }


    /**
     * ������ת(LR��ת) x(��) w y ��� ��y��ɸ����
     * @return
     */
    private AVLNode<T> doubleRotateWithLeft(AVLNode<T> x){
        //w�Ƚ���RR��ת
        x.left=singleRotateRight(x.left);
        //�ٽ���x��LL��ת
        return singleRotateLeft(x);
    }

    /**
     * ������ת(RL��ת)
     * @param w
     * @return
     */
    private AVLNode<T> doubleRotateWithRight(AVLNode<T> x){
        //�Ƚ���LL��ת
        x.right=singleRotateLeft(x.right);
        //�ٽ���RR��ת
        return singleRotateRight(x);
    }


    /**
     * ���뷽��
     * @param data
     */
    public void insert(T data) {
        if (data==null){
            throw new RuntimeException("data can\'t not be null ");
        }
        this.root=insert(data,root);
    }

    private AVLNode<T> insert(T data , AVLNode<T> p){

        //˵����û�к��ӽ��,���Դ����½�������.
        if(p==null){
            p=new AVLNode<T>(data);
        }else if(data.compareTo(p.data)<0){//��������Ѱ�Ҳ���λ��
            p.left=insert(data,p.left);

            //�������������ĸ߶�,����2����Ҫ���»ָ�ƽ��,��������߲���,�������ĸ߶ȿ϶����ڵ����������ĸ߶�
            if(height(p.left)-height(p.right)==2){
                //�ж�data�ǲ��������ӻ����Һ���
                if(data.compareTo(p.left.data)<0){
                    //����LL��ת
                    p=singleRotateLeft(p);
                }else {
                    //����������ת
                    p=doubleRotateWithLeft(p);
                }
            }
        }else if (data.compareTo(p.data)>0){//��������Ѱ�Ҳ���λ��
            p.right=insert(data,p.right);

            if(height(p.right)-height(p.left)==2){
                if (data.compareTo(p.right.data)<0){
                    //����������ת
                    p=doubleRotateWithRight(p);
                }else {
                    p=singleRotateRight(p);
                }
            }
        }
        else
            ;//if exist do nothing
        //���¼���������ĸ߶�
        p.height = Math.max( height( p.left ), height( p.right ) ) + 1;

        return p;//���ظ����
    }

    /**
    **
    ** ɾ������
    * @param data
    */
    public void remove(T data) {
        if (data==null){
            throw new RuntimeException("data can\'t not be null ");
        }
        this.root=remove(data,root);
    }

    /**
     * ɾ������
     *
     * ɾ�������Ƚϸ��ӣ�����ֻ˵һ��ԭ����д�����ˡ�

     1�������ɾ���Ľ����Ҷ�ӽ�㣬��ôֱ��ɾ����Ҷ�ӽ�㣬�����丸����Ӧָ����nullptr��ͬʱ�������������ε�������·���ϵ�ƽ�⡣������򵥵����

     2������ɾ���Ľ��ֻ��һ��������ʱ�򣬽���ɾ�����ĸ�����Ӧ��ָ��ָ���������֮��ɾ���ý�㣬ͬʱ���Ӹø���㿪ʼ�������������ε�������·���ϵ�ƽ�⡣

     3������ɾ���Ľ����������������ʱ���ҵ��ý������ڹؼ��֡�Ȼ�󣬽��ùؼ��ֵ�ֵ��ֵ����ɾ���Ľ�㡣�������Ͱ�����ת��Ϊɾ���ùؼ������ڵ�Ҷ�ӽ�������ˡ�����1���������

     ����һ��ʲô�������ڹؼ��֡����ڲ���Ҷ�ӽ���ϵĹؼ���a���������ڹؼ���Ϊ���������е����ֵ��
     ���������е���Сֵ���Ӹö�����������ؿ��������ڹؼ���һ��λ��Ҷ�ӽ�㴦����ֱ�׵�˵��
     ���ڹؼ��־��ǣ�����a����ָ���������������ĸ���㣬Ȼ��������ָ��һ�������ߣ�ֱ��Ҷ�ӽ��Ϊֹ��
     �����ǣ�  ����a����ָ���������������ĸ���㣬Ȼ��������ָ��һ�������ߣ�ֱ��Ҷ�ӽ��Ϊֹ��

     *
     * @param data
     * @param p
     * @return
     */
    private AVLNode<T> remove(T data,AVLNode<T> p){

        if(p ==null)
            return null;

        int result=data.compareTo(p.data);

        //��������������Ҫɾ����Ԫ��
        if(result<0){
            p.left=remove(data,p.left);

            //����Ƿ�ƽ��
            if(height(p.right)-height(p.left)==2){
                AVLNode<T> currentNode=p.right;
                //�ж���Ҫ������ת
                if(height(currentNode.left)>height(currentNode.right)){
                    //LL
                    p=singleRotateLeft(p);
                }else{
                    //LR
                    p=doubleRotateWithLeft(p);
                }
            }

        }
        //��������������Ҫɾ����Ԫ��
        else if(result>0){
            p.right=remove(data,p.right);
            //����Ƿ�ƽ��
            if(height(p.left)-height(p.right)==2){
                AVLNode<T> currentNode=p.left;
                //�ж���Ҫ������ת
                if(height(currentNode.right)>height(currentNode.left)){
                    //RR
                    p=singleRotateRight(p);
                }else{
                    //RL
                    p=doubleRotateWithRight(p);
                }
            }
        }
        //���ҵ���Ҫɾ����Ԫ��,����Ҫɾ���Ľ��ӵ�������ӽڵ�
        else if(p.right!=null&&p.left!=null){

            //Ѱ���滻��� �������������ӽڵ� �Լ�������С�Ľڵ�
            p.data=findMin(p.right).data;

            //�Ƴ������滻�Ľ��
            p.right = remove( p.data, p.right );
        }
        else {
            //ֻ��һ�����ӽ�����ֻ��Ҷ�ӽ������
            p=(p.left!=null)? p.left:p.right;
        }

        //���¸߶�ֵ
        if(p!=null)
            p.height = Math.max( height( p.left ), height( p.right ) ) + 1;
        return p;
    }


    /**
     * ������Сֵ���
     * @param p
     * @return
     */
    private AVLNode<T> findMin(AVLNode<T> p){
        if (p==null)//��������
            return null;
        else if (p.left==null)//���û������,��ôt������С��
            return p;
        return findMin(p.left);
    }

    public T findMin() {
        return findMin(root).data;
    }

    public T findMax() {
        return findMax(root).data;
    }

    /**
     * �������ֵ���
     * @param p
     * @return
     */
    private AVLNode<T> findMax(AVLNode<T> p){
        if (p==null)
            return null;
        else if (p.right==null)//���û���ҽ��,��ôt��������
            return p;
        return findMax(p.right);
    }

    public BinaryNode findNode(T data) {
        /**
         * @see BinarySearchTree#findNode(Comparable)
         * @return
         */
        return null;
    }

    private void printTree( AVLNode<T> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.data );
            printTree( t.right );
        }
    }

    public boolean contains(T data) {
        return data != null && contain(data, root);
    }

    public boolean contain(T data , AVLNode<T> subtree){

        if (subtree==null)
            return false;

        int result =data.compareTo(subtree.data);

        if (result<0){
            return contain(data,subtree.left);
        }else if(result>0){
            return contain(data,subtree.right);
        }else {
            return true;
        }
    }

    public void clear() {
        this.root=null;
    }


    public String preOrder() {
        String sb=preOrder(root);
        if(sb.length()>0){
            //ȥ��β��","��
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    /**
     * �ȸ�����
     * @param subtree
     * @return
     */
    public String preOrder(AVLNode<T> subtree){
        StringBuilder sb =new StringBuilder();
        if (subtree!=null) {
            //�ȷ��ʸ����
            sb.append(subtree.data).append(",");
            //����������
            sb.append(preOrder(subtree.left));
            //����������
            sb.append(preOrder(subtree.right));
        }
        return sb.toString();
    }

    public String inOrder() {
        String sb=inOrder(root);
        if(sb.length()>0){
            //ȥ��β��","��
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    /**
     * �и�����
     * @param subtree
     * @return
     */
    private String inOrder(AVLNode<T> subtree){
        StringBuilder sb =new StringBuilder();
        if (subtree!=null) {
            //����������
            sb.append(inOrder(subtree.left));
            //���ʸ����
            sb.append(subtree.data).append(",");
            //����������
            sb.append(inOrder(subtree.right));
        }
        return sb.toString();
    }

    public String postOrder() {
        String sb=postOrder(root);
        if(sb.length()>0){
            //ȥ��β��","��
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    /**
     * �������
     * @param subtree
     * @return
     */
    private String postOrder(AVLNode<T> subtree){
        StringBuilder sb =new StringBuilder();
        if (subtree!=null){
            //����������
            sb.append(postOrder(subtree.left));
            //����������
            sb.append(postOrder(subtree.right));
            //���ʸ����
            sb.append(subtree.data).append(",");
        }
        return sb.toString();
    }

    public String levelOrder() {
        /**
         * @see BinarySearchTree#levelOrder()
         * @return
         */
        return null;
    }



    /**
     * ����
     * @param arg
     */
    public  static void main(String arg[]){

        AVLTree<Integer> avlTree=new AVLTree<>();

        for (int i = 1; i <18 ; i++) {
            avlTree.insert(i);
        }

        avlTree.printTree(avlTree.root);
       /* //ɾ��11,8�Դ�����תƽ�����
        avlTree.remove(11);
        avlTree.remove(8);
*/
        System.out.println("================");

        avlTree.printTree(avlTree.root);

        System.out.println("findMin:"+avlTree.findMin());

        System.out.println("findMax:"+avlTree.findMax());

        System.out.println("15 exist or not : " + avlTree.contains(15) );

        System.out.println("�ȸ�����:"+avlTree.preOrder());

        System.out.println("�и�����:"+avlTree.inOrder());

        System.out.println("�������:"+avlTree.postOrder());

    }


}
