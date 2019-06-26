package cn.zy.sort;

/**
 * @Title: �����㷨
 * @Project:
 *
 *
 * �ȶ������aԭ����bǰ�棬��a=b������֮��a��Ȼ��b��ǰ�档
 *���ȶ������aԭ����b��ǰ�棬��a=b������֮�� a ���ܻ������ b �ĺ��档
 *ʱ�临�Ӷȣ����������ݵ��ܵĲ�����������ӳ��n�仯ʱ��������������ʲô���ɡ�
 *�ռ临�Ӷȣ���ָ�㷨�ڼ���� ��ִ��ʱ����洢�ռ�Ķ�������Ҳ�����ݹ�ģn�ĺ�����
 * @Author: zy
 * @Description:
 * @Date: Create in 10:35 2019/3/31
 */
public class Sort {


    /**
     * ��������
     * һ�����������޸�һ�������������͵Ĳ�������ֵ�ͺͲ����ͣ���

     һ�����������޸�һ��������ָ��Ķ���״̬��������Ȼ�ǰ�ֵ���ö������õ��á�

     �������ִ��ݶ�������ֵ�����Ĺ��̡�
     *
     *
     * @param a �������
     * @param i
     * @param j
     */
    public static void swap(int a[],int i,int j){

        //����д��
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
     * ��򵥵������㷨  ���Ӷ�Ϊ
     * ð���㷨
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

      /* for(int i=0; i<arr.length; i++){//��ʾn��������̡�
           for( int j=1; j<arr.length-i; j++){
               if(arr[j-1] > arr[j]){//ǰ������ִ��ں�������־ͽ���
                   //����a[j-1]��a[j]
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
     * ѡ������
     *ѡ������(Selection-sort)��һ�ּ�ֱ�۵������㷨�����Ĺ���ԭ��������δ�����������ҵ���С����Ԫ�أ�
     * ��ŵ��������е���ʼλ�ã�Ȼ���ٴ�ʣ��δ����Ԫ���м���Ѱ����С����Ԫ�أ�Ȼ��ŵ����������е�ĩβ��
     * �Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ�
     *
     * ��� ��������ѡ��ÿ����С�� ������ǰ��
     *
     *
     * n����¼��ֱ��ѡ������ɾ���n-1��ֱ��ѡ������õ��������������㷨�������£�

         ��ʼ״̬��������ΪR[1..n]��������Ϊ�գ�
         ��i������(i=1,2,3��n-1)��ʼʱ����ǰ���������������ֱ�ΪR[1..i-1]��R(i..n����
         ��������ӵ�ǰ��������-ѡ���ؼ�����С�ļ�¼ R[k]���������������ĵ�1����¼R������
         ʹR[1..i]��R[i+1..n)�ֱ��Ϊ��¼��������1�������������ͼ�¼��������1��������������
     n-1�˽��������������ˡ�
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
     * ����
     * ����һ����������� ÿ������������в�������
     *һ����˵���������򶼲���in-place��������ʵ�֡������㷨�������£�

     �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
     ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ�裻
     �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�ã�
     �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�ã�
     ����Ԫ�ز��뵽��λ�ú�
     �ظ�����2~5��
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
     * �鲢���� �ݹ��˼��
     * @param data
     */
    public static void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int left, int right) {
        if (left >= right)
            return;
        // �ҳ��м�����
        int center = (left + right) / 2;
        // �����������еݹ�
        sort(data, left, center);
        // ���ұ�������еݹ�
        sort(data, center + 1, right);
        // �ϲ�
        merge(data, left, center, right);
        print(data);
    }

    /**
     * ������������й鲢���鲢ǰ��2�����������򣬹鲢����Ȼ����
     *
     * @param data
     *            �������
     * @param left
     *            ������ĵ�һ��Ԫ�ص�����
     * @param center
     *            ����������һ��Ԫ�ص�������center+1���������һ��Ԫ�ص�����
     * @param right
     *            ���������һ��Ԫ�ص�����
     */
    private static void merge(int[] data, int left, int center, int right) {
        // ��ʱ����
        int[] tmpArr = new int[data.length];
        // �������һ��Ԫ������
        int mid = center + 1;
        // third ��¼��ʱ���������
        int third = left;
        // �����������һ��Ԫ�ص�����
        int tmp = left;
        while (left <= center && mid <= right) {
            // ������������ȡ����С�ķ�����ʱ����
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // ʣ�ಿ�����η�����ʱ���飨ʵ��������whileֻ��ִ������һ����
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // ����ʱ�����е����ݿ�����ԭ������
        // ��ԭleft-right��Χ�����ݱ����ƻ�ԭ���飩
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }







}
