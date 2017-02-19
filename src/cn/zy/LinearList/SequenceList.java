package cn.zy.LinearList;

public class SequenceList implements LinearList {
	
	private Object[] seqList;
	
	private int size;
	
	public SequenceList(int length){
		if(length<0){
			throw new IndexOutOfBoundsException("数值越界");
		}
		if(length==0){
			this.seqList=new Object[3];
		}
		this.seqList=new Object[length];
	}

	public SequenceList() {  
	   this.size=0;
	}
	
	public boolean isEmpty() {
		if(this.size==0){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		
		return this.size();
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
		for(int i=index;i<this.size-1;i++){
			this.seqList[i] = this.seqList[i+1];
		}
		this.seqList[this.size-1]=null;
		this.size--;
		return old;
	}

	@Override
	public boolean add(Object element) {
		return add(this.size,element);
	}

	@Override
	public boolean add(int index, Object element) {
		checkIndex(index);
		for(int i=size;i>index;i--){
			this.seqList[this.size] = this.seqList[this.size-1];
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
		this.size=0;

	}
	
	private boolean checkIndex(int index){
		if(index<0||index>this.size){
			throw new IndexOutOfBoundsException("index"+index+",size"+size);
		}
		return true;
	}
	
	public static void main(String args[]){
		LinearList l = new SequenceList();
		for(int i = 0;i<5;i++){
			l.add(i,i);
		}
		for(int i = 0;i<l.size();i++){
			System.out.println(l.get(i));
		}
		
	}

}
