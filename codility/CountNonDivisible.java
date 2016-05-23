package com.jhlc.second.second.saunfa;

/**
 * Created by licheng on 8/1/16.
 */
public class CountNonDivisible {
    public static void main(String[] args) {
        int[] A = {3,1,2,0,6};
        for (int i = 0; i < A.length; i++) {
            System.out.print(solution(A)[i] + " ");
        }
    }

    //66分 https://codility.com/demo/results/training5G6KAK-JMW/
    public static int[] solution(int[] A){
        int len = A.length;
        int[] results = new int[len];
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if(A[j] != 0 && A[i] % A[j] != 0){
                    count ++;
                }
            }
            results[i] = count;
        }
        return results;
    }
}
