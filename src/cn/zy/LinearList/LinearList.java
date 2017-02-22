package cn.zy.LinearList;
/**
 *线性表特点：除开第一个和最后一个数据元素外每一个数据元素只有一个前驱数据元素和一个后继数据元素。
 *线性表是一个简单的线性结构，可以在任意数据元素进行插入
 *@autho zy
 *试试水，做好准备自己从此开始坚持
 * */
public interface LinearList {
	
	//判断线性表是否为空
	public boolean isEmpty();
	//返回线性表容量大小
	public int size();
	//要修改的索引和元素类容  
    public void update(int index,Object element); 
	//得到线性表某个位置的数据
	public Object get(int index);
	//删除某一位置的元素
	public Object remove(int index);
	// 向线性表添加元素  
    public boolean add(Object element);
    //添加元素的位置和添加元素的内容  
    public boolean add(int index,Object element);  
	//清除线性表中元素的方法  
    public void clear();
    //根据
    public int indexof(Object t);
    //
    public void display();
  
	
}
