package com.jhlc.second.second.saunfa;

/**
 * Created by licheng on 23/12/15.
 */
public class CountDiv {
    public static void main(String[] args) {
        System.out.println(solution(12,32,2));
    }

    public static int solution(int A,int B,int K){
        return B/K-(A/K)+(A%K==0?1:0);
    }
}
