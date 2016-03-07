package com.jhlc.second.second.saunfa;

import java.util.Arrays;

/**
 * Created by licheng on 26/12/15.
 */
public class Triangle {
    public static void main(String[] args) {
        int[] str = {10,2,5,1,8,20};
        System.out.println(solution(str));
        System.out.println(solution2(str));
    }

    //56分 https://codility.com/demo/results/training4X29ZE-2G5/
    public static int solution(int[] A){
        int length = A.length;
        int count = 0;
        for(int i = 0; i < length; i ++){
            int a = A[i];
            for(int j = i + 1; j < length; j ++){
                int b = A[j];
                for(int z = j + 1; z < length; z ++){
                    int c = A[z];
                    if(isTrangle(a,b,c)){
                        count ++;
                    }
                }
            }
        }
        if(count > 0){
            return 1;
        }else {
            return 0;
        }
    }
    public static boolean isTrangle(int a, int b, int c){
        if(a +b > c && a + c > b && b + c > a){
            return true;
        }else {
            return false;
        }
    }

    //100分 https://codility.com/demo/results/training8Y7ZWD-PXD/
    public static int solution2(int[] A) {
        int length = A.length;
        if (A == null || length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < length; i++) {
            if (A[i] > 0 && A[i] > A[i + 2] - A[i + 1]) {
                return 1;
            }
        }
        return 0;
    }


    public static int getMax(int[] A){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i ++){
            if(A[i] > max){
                max = A[i];
            }
        }
        return max;
    }


}
