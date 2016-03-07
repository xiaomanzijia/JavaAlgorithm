package com.jhlc.second.second.saunfa;

import java.text.DecimalFormat;

/**
 * Created by licheng on 24/12/15.
 */
public class MinAvgTwoSlice {
    public static void main(String[] args) {
        int[] str = {4,2,2,5,1,5,8,3,44,3,2,5,2,6,4,34,366,4};
        System.out.println(solution(str));
    }

    //60分 https://codility.com/demo/results/trainingDMJDCW-FDE/
    public static int solution(int[] A){
        DecimalFormat df = new DecimalFormat("####.00");
        int length = A.length;
        int counts = 0;
        for(int i = 1 ; i < length; i++){
            counts += i;
        }
        double[] B = new double[counts];
        double sum  = 0;
        double min = Double.MAX_VALUE;
        int minIndex = 0;
        int count = 0;
        double div = 1.0;
        double result = 0.0;
        for(int i = 0 ; i < length; i ++){
            sum = sum + A[i];
            for(int j = i+1;j < length; j++){
                sum = sum + A[j];
                div = j-i+1;
                result = sum / div;
                if(result < min){
                    min = result;
                    minIndex = i;
                }
                B[count] = result;
                count++;
            }
            sum = 0;
        }
        for(int i = 0 ; i < counts; i ++){
            System.out.print(df.format(B[i])+" ");
        }
        return minIndex;
    }
}
