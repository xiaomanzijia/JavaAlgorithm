package datastruct.ErChaShu.sort;

import java.util.HashMap;

/**
 * Created by licheng on 21/5/16.
 */
public class InsertSort {
    public static void main(String[] args) {
        int a[]={1,2,2,3};
        int b[]={1,2,4,5};
        int c[] = {2,4,5,3,6,2,1,6,27,9,5,6,6,7,10,4,10,3,3};
        chazhao(c);
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
    public static void bingSort(int[] a, int[] b) {
        int result[] = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;   //i:用于标示a数组    j：用来标示b数组  k：用来标示传入的数组
        while (i < a.length && j < b.length)
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }

        /* 后面连个while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入 */
        while (i < a.length)
            result[k++] = a[i++];
        while (j < b.length)
            result[k++] = b[j++];

        for (int ii = 0; ii < result.length; ii++) {
            System.out.print(result[ii] + " ");
        }
    }




    //查找数组数字重复次数
    public static int chazhao(int[] a){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])){
                int aa = map.get(a[i]);
                aa ++ ;
                map.put(a[i],aa);
            }else {
                map.put(a[i],1);
            }
        }
        for (Integer i : map.keySet()){
            System.out.println(i+" "+map.get(i));
        }
        return 0;
    }





}
