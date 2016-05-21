package datastruct.ErChaShu.sort;

/**
 * Created by licheng on 21/5/16.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {43,23,56,32,12,67,34,89,22};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    //插入排序
    public static void insertSort(int[] a) {
        int temp = 0;
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            temp = a[i];
            for (; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];                       //将大于temp的值整体后移一个单位
            }
            a[j + 1] = temp;
        }

    }

    //简单选择排序
    public static void selectSort(int[] a){
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            int min = Integer.MAX_VALUE;
            int temp = a[i];
            for (int j = i ; j < a.length; j++) {
                if(a[j] < min){
                    min = a[j];
                    index = j;
                }
            }
            a[index] = temp;
            a[i] = min;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] a){
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if(a[j] > a[j + 1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    //快速排序
    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }
    public static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }
    public static void quick(int[] a2) {
        if (a2.length > 0) {    //查看数组是否为空
            _quickSort(a2, 0, a2.length - 1);
        }
    }

    public static void sort(int[] a){
        int low = 0;
        int high = a.length - 1;
        int temp = a[0];
        while (low < high){
            while (low < high && a[high] >= temp){
                high --;
            }
            a[low] = a[high]; //找到比temp小的就移到temp左边
            while (low < high && a[low] <= temp){
                low ++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
    }

    //归并排序




}
