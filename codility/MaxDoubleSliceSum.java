package com.jhlc.second.second.saunfa;


/**
 * Created by licheng on 2/1/16.
 */
public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        int[] A = {3,2,6,-1,4,5,-1,2};
        System.out.println(solution(A));
        System.out.println(solution2(A));

    }

    //53   https://codility.com/demo/results/trainingX3K64E-MCR/
    public static int solution(int[] A){
        int length = A.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int a = A[i];
            for (int j = i + 1; j < length; j++) {
                int b = A[j];
                for (int z = j + 1; z < length; z++) {
                    int c = A[z];
                    int sum = 0;
                    int sumtemp = a + b + c;
                    for (int ii = i; ii < z + 1; ii++) {
                        sum += A[ii];
                    }
                    int resulttemp = sum - sumtemp;
                    if(resulttemp > max){
                        max = resulttemp;
                    }
                }
            }
        }
        return max;
    }

    public static int solution2(int[] A) {
        int[] maxStartingHere = new int[A.length];
        int[] maxEndingHere = new int[A.length];
        int maxSum = 0, len = A.length;

        for(int i = len - 2; i > 0; --i ) {
            maxSum = Math.max(0, A[i] + maxSum);
            maxStartingHere[i] = maxSum;
        }
        maxSum = 0;
        for(int i = 1; i < len - 1; ++i ) {
            maxSum = Math.max(0, A[i] + maxSum);
            maxEndingHere[i] = maxSum;
        }
        int maxDoubleSlice = 0;

        for(int i = 0; i < len - 2; ++i) {
            maxDoubleSlice = Math.max(maxDoubleSlice, maxEndingHere[i] + maxStartingHere[i+2]);
        }
        return maxDoubleSlice;
    }
}
