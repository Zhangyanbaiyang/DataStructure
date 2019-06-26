package cn.zy.sort;

/**
 * @Title: 排序算法
 * @Project:
 *
 *
 * 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。
 *不稳定：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。
 *时间复杂度：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。
 *空间复杂度：是指算法在计算机 内执行时所需存储空间的度量，它也是数据规模n的函数。
 * @Author: zy
 * @Description:
 * @Date: Create in 10:35 2019/3/31
 */
public class Sort {


    /**
     * 交换数字
     * 一个方法不能修改一个基本数据类型的参数（数值型和布尔型）。

     一个方法可以修改一个引用所指向的对象状态，但这仍然是按值调用而非引用调用。

     上面两种传递都进行了值拷贝的过程。
     *
     *
     * @param a 数组对象
     * @param i
     * @param j
     */
    public static void swap(int a[],int i,int j){

        //错误写法
      /*  int temp;
        temp = a;
        a =b;
        b =temp;*/


        int temp;
        temp = a[i];
        a[i] =  a[j];
        a[j] =temp;



    }


    private static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+">>");
        }
        System.out.println();
    }

    /**
     * 最简单的排序算法  复杂度为
     * 冒泡算法
     * @param arr
     */
   public static void bubbleSort(int arr[]){

       print(arr);
       for (int i = 0; i < arr.length - 1; i++) {
           for (int j = 1; j < arr.length - 1 - i; j++) {
                if(arr[j-1] > arr[j]){
                    swap(arr,j,j-1);
                }
           }
       }

      /* for(int i=0; i<arr.length; i++){//表示n次排序过程。
           for( int j=1; j<arr.length-i; j++){
               if(arr[j-1] > arr[j]){//前面的数字大于后面的数字就交换
                   //交换a[j-1]和a[j]
                  *//* int temp;
                   temp = arr[j-1];
                   arr[j-1] = arr[j];
                   arr[j]=temp;*//*
                   swap(arr[j-1],arr[j]);
               }
           }
       }*/

       print(arr);
   }


    /**
     * 选择排序
     *选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，
     * 存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * 理解 便利数组选择每次最小的 放在最前面
     *
     *
     * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：

         初始状态：无序区为R[1..n]，有序区为空；
         第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
         该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
         使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     n-1趟结束，数组有序化了。
     * @param arr
     */
    public static void selectSort(int arr[]){

        print(arr);
        int minIndex,temp;
        for(int i=0;i<arr.length-1;i++){
            minIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        print(arr);
    }


    /**
     * 插入
     * 创建一个有序的数组 每次往这个数组中插入最大的
     *一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

     从第一个元素开始，该元素可以认为已经被排序；
     取出下一个元素，在已经排序的元素序列中从后向前扫描；
     如果该元素（已排序）大于新元素，将该元素移到下一位置；
     重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     将新元素插入到该位置后；
     重复步骤2~5。
     *
     * @param arr
     */
    public static void insertSort(int[] arr){

        print(arr);
        int preIndex,current;
        for(int i=1;i<arr.length;i++){
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        print(arr);
    }


    /**
     * 归并排序 递归的思想
     * @param data
     */
    public static void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int left, int right) {
        if (left >= right)
            return;
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        sort(data, left, center);
        // 对右边数组进行递归
        sort(data, center + 1, right);
        // 合并
        merge(data, left, center, right);
        print(data);
    }

    /**
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
     *
     * @param data
     *            数组对象
     * @param left
     *            左数组的第一个元素的索引
     * @param center
     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right
     *            右数组最后一个元素的索引
     */
    private static void merge(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }







}
