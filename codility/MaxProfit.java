package com.jhlc.second.second.saunfa;

/**
 * Created by licheng on 2/1/16.
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] A = {23171,21011,21123,21366,21013,21367};
        System.out.println(solution(A));
    }
    public static  int solution(int[] A) {
        int maxEnd = 0;
        int maxSlice = 0;

        if (A.length < 2) return 0;

        for (int i = 1; i < A.length; i++) {
            int delta = A[i] - A[i - 1];

            maxEnd = Math.max(0, maxEnd + delta);

            maxSlice = Math.max(maxSlice, maxEnd);
        }

        if(maxSlice < 0) return 0;

        return maxSlice;
    }
}
