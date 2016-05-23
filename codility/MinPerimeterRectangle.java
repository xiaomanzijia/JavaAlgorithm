package com.jhlc.second.second.saunfa;

/**
 * Created by licheng on 3/1/16.
 */
public class MinPerimeterRectangle {
    public static void main(String[] args) {
        System.out.println(solution(30));

    }

    //100分 https://codility.com/demo/results/trainingDCAYWT-FH7/
    public static int solution(int N){
        int a = (int) Math.sqrt(N);
        int c = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= a; i++) {
            if(N % i == 0){
                int b = N / i;
                c = (i + b) * 2;
                if(c < min){
                    min = c;
                }
            }
        }
        return min;
    }
}
