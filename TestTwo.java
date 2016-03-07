package com.jhlc.second.second.saunfa;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by licheng on 22/12/15.
 */
//找到迷失的数字
public class TestTwo {
    public static void main(String[] args) {
        int[] str = {2,4,1,5};
//        bubbleSort(str);
//        for(int i = 0; i < str.length; i ++){
//            System.out.print(str[i]+" ");
//        }
        System.out.print(solution2(str));
    }
    public static int solution(int[] A){
        int temp; // 记录临时中间值
        int L = A.length; // 数组大小
        for (int i = 0; i < L - 1; i++) {
            for (int j = i + 1; j < L; j++) {
                if (A[i] > A[j]) { // 交换两数的位置
                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        int tag = 0;
        int b = A[0];
        int a = A[L-1] - A[0] + 1;
        int[] B = new int[a];
        for(int i = 0; i < a;i++){
            B[i] = b + i;
        }
        for(int i = 0;i<L;i++){
            if(A[i]!=B[i]){
                tag = i;
                break;
            }
        }
        return B[tag];
    }


    public static int solution2(int[] A){
        int keyvalue = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < A.length;i++){
            if(A[i]<min) min=A[i];
        }
        Map<Integer,Integer>  map = new HashMap<>();
        for(int i = 0 ; i < A.length+1; i ++){
            map.put(min+i,0);
        }
        for(Integer key : map.keySet()){
            System.out.println("key:"+key+"value:"+map.get(key));
        }
        return keyvalue;
    }

    //冒泡排序
    public static void bubbleSort(int[] numbers) {
        int temp; // 记录临时中间值
        int size = numbers.length; // 数组大小
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] > numbers[j]) { // 交换两数的位置
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }



}
