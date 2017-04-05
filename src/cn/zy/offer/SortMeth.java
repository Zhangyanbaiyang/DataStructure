package cn.zy.offer;

public class SortMeth {
	
	public int[] bubbleSort(int s[]){
		int i,j;
		int temp;
		int length = s.length;
		for(i = 0;i<length;i++){
			for(j=i+1;j<length;j++){
				if(s[j]<s[i]){
					temp = s[j];
					s[j] = s[i];
					s[i] = temp;
				}
			}
		}
		return s;
		
	}
	
	
	public int[] insertSort(int s[]){
		
		return s;
		
	}

}
