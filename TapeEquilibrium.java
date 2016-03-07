package com.jhlc.second.second.saunfa;

/**
 * Created by licheng on 23/12/15.
 */
public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] str = {1,2,3,4};
        System.out.println(solution(str));
    }

    public static int solution(int[] A){
        int length = A.length;
        int sum = 0;
        int leftSum = 0;
        int result = 0;
        int min = Integer.MAX_VALUE;

        if(length==0){
            min = 0;
        }else if(length==1){
            min = A[0];
        }else{
            int[] results = new int[length-1];
            for(int i = 0; i < length; i ++){
                sum += A[i];
            }
            for(int i = 0; i < length-1; i++){
                leftSum += A[i];
                result = sum - 2 * leftSum;
                if(result<0){
                    result = -result;
                }
                results[i] = result;
            }
            for(int i = 0;i < length-1;i++){
                if(results[i]<min) min=results[i];
            }
        }
        return min;
    }
}
