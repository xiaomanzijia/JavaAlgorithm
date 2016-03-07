package com.jhlc.second.second.saunfa;

/**
 * Created by licheng on 4/1/16.
 */
public class CountFactors {
    public static void main(String[] args) {
        System.out.println(solution(9));
    }

    //100分 https://codility.com/demo/results/trainingDPHYNG-BJD/
    public static int solution(int N){
        int a = (int) Math.sqrt(N);
        int count = 0;
        int b = 0;
        for (int i = 1; i <= a; i++) {
            if(N % i == 0){
                count ++;
                b = i;
            }
        }
        return b * b == N ? 2 * count - 1 : 2 * count;
    }
}
