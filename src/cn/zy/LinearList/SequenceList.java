package cn.zy.LinearList;

public class SequenceList implements LinearList {
	
	//��ʼ������
	private static final int INITIAL_CAPACITY = 16;
	
	//ʹ��������Ϊ�ײ�洢
	private Object[] seqList;
	
	//��ʵ������С
	private int size;
	
	//���������
	private int capacity;
	
	public SequenceList(){
		seqList = new Object[INITIAL_CAPACITY];
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void update(int index, Object element) {
		checkIndex(index);
		this.seqList[index] = element;
	}

	@Override
	public Object get(int index) {
		checkIndex(index);
		return (Object)this.seqList[index];
	}

	@Override
	public Object remove(int index) {
		checkIndex(index);
		Object old = this.get(index);
		int count = 0;
		for(int i=index;i<this.size-1;i++){
			this.seqList[i] = this.seqList[i+1];
			count++;
		}
		this.seqList[this.size-1]=null;
		this.size--;
		System.out.println(count);
		return old;
	}

	@Override
	public boolean add(Object element) {
		ensureCapacity();
		return add(this.size,element);
	}

	@Override
	public boolean add(int index, Object element) {
		checkIndex(index);
		ensureCapacity();
		for(int i=size;i>index;i--){
			this.seqList[i] = this.seqList[i-1];
		}
		this.seqList[index] = element;
		this.size++;		
		return true;
	}

	@Override
	public void clear() {
		if(this.size!=0){
			for(int i=0;i<size;i++){
				this.seqList[i]=null;
			}
		}
		Object newData[] = new Object[0];
		//this.seqList = newData;
		this.size=0;
	}
	
	public int indexof(Object t) {
		for(int i = 0;i<this.size;i++){
			if(this.seqList[i].equals(t)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public void display() {
		for(int i = 0;i<this.size();i++)
			System.out.println(this.seqList[i]);
	}

	private boolean checkIndex(int index){
		if(index<0||index>this.size){
			throw new IndexOutOfBoundsException("��������λ�ó������� index"+index+",size"+size);
		}
		return true;
	}
	
	//���ײ���������������ʱ�򣬽����Զ�����
	private void ensureCapacity(){
		if(size>=seqList.length){
			Object[] newObject = new Object[seqList.length*2];
			System.arraycopy(seqList, 0, newObject, 0, seqList.length);
			seqList = newObject;
		}
	}

}
