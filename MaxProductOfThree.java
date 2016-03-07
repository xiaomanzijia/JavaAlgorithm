package com.jhlc.second.second.saunfa;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by licheng on 24/12/15.
 */
public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] str = {10,10,10,10,10,-2,34,12,-3,-1234};
        System.out.println(solution(str));
        System.out.println(solution2(str));
    }

    //44分 https://codility.com/demo/results/training62EA7S-4MC/
    public static int solution(int[] A){
        int length = A.length;
        int max = Integer.MIN_VALUE;
        int result = 1;
        for(int i = 0; i < length - 1; i ++){
            int a = A[i];
            for(int j = i + 1; j < length; j ++){
                int b = A[j];
                for(int z = j + 1; z < length; z++){
                    int c = A[z];
                    result = a * b *c;
                    if(result > max){
                        max = result;
                    }
                }
            }
        }
        return max;
    }

    //快排88分 https://codility.com/demo/results/training8DBT5F-2ZM/
    //归并100分 https://codility.com/demo/results/trainingN9YH3N-GSW/
    public static int solution2(int[] A){
        int length = A.length;
        Arrays.sort(A);
//        _quickSort(A,0,length-1);
        int a = A[0]*A[1]*A[length-1];
        int b = A[length-1]*A[length-2]*A[length-3];
        return a>b?a:b;
    }

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
}
