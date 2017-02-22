package cn.zy.LinearList;

public class SequenceList implements LinearList {
	
	//初始化容量
	private static final int INITIAL_CAPACITY = 16;
	
	//使用数组作为底层存储
	private Object[] seqList;
	
	//真实容量大小
	private int size;
	
	//数组的容量
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
			throw new IndexOutOfBoundsException("插入数字位置超过表长度 index"+index+",size"+size);
		}
		return true;
	}
	
	//当底层数组容量不够的时候，进行自动扩容
	private void ensureCapacity(){
		if(size>=seqList.length){
			Object[] newObject = new Object[seqList.length*2];
			System.arraycopy(seqList, 0, newObject, 0, seqList.length);
			seqList = newObject;
		}
	}

}
