package com.jhlc.second.second.saunfa;

/**
 * Created by licheng on 23/12/15.
 */
public class TestThree {
    public static void main(String[] args) {
        int[] str = {1231432535};
        System.out.println(solution(str));

    }

    public static int solution(int[] A){
        int length = A.length;
        int sum = 0;
        int shouldSum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < length;i++){
            if(A[i]<min) min=A[i];
        }
        for(int i = 0; i < length+1; i ++){
            if(i<length){
                sum += A[i];
            }
            if(length==1){
                shouldSum = min + shouldSum;
            }else {
                shouldSum = min + i +shouldSum;
            }
        }
        return shouldSum - sum;
    }

    //获得最小值
    public static int getMin(int[] A){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < A.length;i++){
            if(A[i]<min) min=A[i];
        }
        return min;
    }
}
