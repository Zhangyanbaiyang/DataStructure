package cn.zy.LinearList;
/**
 *���Ա��ص㣺������һ�������һ������Ԫ����ÿһ������Ԫ��ֻ��һ��ǰ������Ԫ�غ�һ���������Ԫ�ء�
 *���Ա���һ���򵥵����Խṹ����������������Ԫ�ؽ��в���
 *@autho zy
 *����ˮ������׼���Լ��Ӵ˿�ʼ���
 * */
public interface LinearList {
	
	//�ж����Ա��Ƿ�Ϊ��
	public boolean isEmpty();
	//�������Ա�������С
	public int size();
	//Ҫ�޸ĵ�������Ԫ������  
    public void update(int index,Object element); 
	//�õ����Ա�ĳ��λ�õ�����
	public Object get(int index);
	//ɾ��ĳһλ�õ�Ԫ��
	public Object remove(int index);
	// �����Ա����Ԫ��  
    public boolean add(Object element);
    //���Ԫ�ص�λ�ú����Ԫ�ص�����  
    public boolean add(int index,Object element);  
	//������Ա���Ԫ�صķ���  
    public void clear();
    //����
    public int indexof(Object t);
    //
    public void display();
  
	
}
