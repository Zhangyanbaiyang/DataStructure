package cn.zy.sort;

/**
 * @Title: �����㷨����
 * @Project:
 * @Author: zy
 * @Description:
 * @Date: Create in 11:08 2019/3/31
 */
public class TestSort {


    public static void main(String args[]){

        long now = System.currentTimeMillis();
        int arr[] = {1,5,989,23,12,78,79,20};

        //ð������
        //Sort.bubbleSort(arr);

        ////ѡ������
        Sort.selectSort(arr);


        //��������
        Sort.insertSort(arr);


        //�鲢����
        //Sort.mergeSort(arr);
        long end = System.currentTimeMillis();

        System.out.println("sort waste time "+(end-now));




    }
}
