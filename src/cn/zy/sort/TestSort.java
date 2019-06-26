package cn.zy.sort;

/**
 * @Title: ≈≈–ÚÀ„∑®≤‚ ‘
 * @Project:
 * @Author: zy
 * @Description:
 * @Date: Create in 11:08 2019/3/31
 */
public class TestSort {


    public static void main(String args[]){

        long now = System.currentTimeMillis();
        int arr[] = {1,5,989,23,12,78,79,20};

        //√∞≈›≈≈–Ú
        //Sort.bubbleSort(arr);

        ////—°‘Ò≈≈–Ú
        Sort.selectSort(arr);


        //≤Â»Î≈≈–Ú
        Sort.insertSort(arr);


        //πÈ≤¢≈≈–Ú
        //Sort.mergeSort(arr);
        long end = System.currentTimeMillis();

        System.out.println("sort waste time "+(end-now));




    }
}
