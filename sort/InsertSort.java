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
    
    
    
    
    //-------快排一次循环------------
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

    //------------快速排序------------
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
    //----------快速排序结束-----------------
    
    
    
    //--------整合两个有序序列----------
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

    //---------归并排序-----------
    public static void Merge(int[] array, int low, int mid, int high) {
        int i = low; // i是第一段序列的下标
        int j = mid + 1; // j是第二段序列的下标
        int k = 0; // k是临时存放合并序列的下标
        int[] array2 = new int[high - low + 1]; // array2是临时合并序列
        
        // 扫描第一段和第二段序列，直到有一个扫描结束
        while (i <= mid && j <= high) {
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (array[i] <= array[j]) {
                array2[k] = array[i];
                i++;
                k++;
            } else {
                array2[k] = array[j];
                j++;
                k++;
            }
        }
        
        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while (i <= mid) {
            array2[k] = array[i];
            i++;
            k++;
        }
        
        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (j <= high) {
            array2[k] = array[j];
            j++;
            k++;
        }
        
        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++) {
            array[i] = array2[k];
        }
    }
    
    public static void MergePass(int[] array, int gap, int length) {
        int i = 0;
        
        // 归并gap长度的两个相邻子表
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
            Merge(array, i, i + gap - 1, i + 2 * gap - 1);
        }
        
        // 余下两个子表，后者长度小于gap
        if (i + gap - 1 < length) {
            Merge(array, i, i + gap - 1, length - 1);
        }
    }
    
    public static int[] sort(int[] list) {
        for (int gap = 1; gap < list.length; gap = 2 * gap) {
            MergePass(list, gap, list.length);
            System.out.print("gap = " + gap + ":\t");
            printAll(list);
        }
        return list;
    }
    
    // 打印完整序列
    public static void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
    
    //-----归并排序结束---------
    




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
