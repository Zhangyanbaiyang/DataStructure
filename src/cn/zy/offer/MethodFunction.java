package cn.zy.offer;

import java.util.ArrayList;
public class MethodFunction {
	
	//在一个二维数组中，从左到右增，从上到下递增。给出一个二维数组和一个整数，看整数是否存在于二维数组中。
	
	//解法1  挨个遍历，死办法
	
	//解法2 可以从左下角或者右上角为出发点，因为二维数组是有规律的,从左下角开始
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
	
	//尾部开始链表打印
	
	public ArrayList<Integer> printListFromLast(Node head){
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		if(head!=null){
			printListFromLast(head.next);
			a.add(head.data);
		}
		
		return a;
	}
}
