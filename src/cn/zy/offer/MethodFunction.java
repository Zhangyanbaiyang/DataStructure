package cn.zy.offer;

import java.util.ArrayList;
public class MethodFunction {
	
	//��һ����ά�����У��������������ϵ��µ���������һ����ά�����һ���������������Ƿ�����ڶ�ά�����С�
	
	//�ⷨ1  �������������취
	
	//�ⷨ2 ���Դ����½ǻ������Ͻ�Ϊ�����㣬��Ϊ��ά�������й��ɵ�,�����½ǿ�ʼ
	public boolean find(int array[][],int target){
		if(array==null){
			return false;
		}
		int row = array.length;
		int col = array[0].length;
		int i,j;
		for(i=row-1,j=0;i>=0&&j<col;){
			if(target == array[i][j]){
				return true;
			}
			
			if(target<array[i][j]){
				i--;
				continue;
			}
			
			if(target>array[i][j]){
				j++;
				continue;
			}
		}
		
		return false;
	}
	
	//β����ʼ�����ӡ
	
	public ArrayList<Integer> printListFromLast(Node head){
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		if(head!=null){
			printListFromLast(head.next);
			a.add(head.data);
		}
		
		return a;
	}
}
