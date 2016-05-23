package com.jhlc.second.second.saunfa;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by licheng on 19/1/16.
 */
public class ChocolatesByNumbers {
    public static void main(String[] args) {
        System.out.println(solution(10,4));
    }

    public static int solution(int N, int M){
        //0 1 2 3 4 5 6 7 8 9
        int lcm = N * M / gcd(N,M);
        return lcm / M;
    }

    public static int gcd(int a, int b){
        if(a % b == 0){
            return b;
        }else {
            return gcd(a,a % b);
        }
    }
}
