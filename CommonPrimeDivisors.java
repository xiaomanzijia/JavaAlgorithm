package com.jhlc.second.second.saunfa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by licheng on 19/1/16.
 */
public class CommonPrimeDivisors {
    public static void main(String[] args) {
        int[] A = {15,10,3};
        int[] B = {75,30,5};
        System.out.println(solution(A,B));
    }

    //23分  https://codility.com/demo/results/trainingPT7CVD-6MJ/
    public static int solution(int[] A,int[] B){
        int len = A.length;
        //获取A B 中最大数的开方数
        Set<Integer> set = primes(getMax(A,B));
        int setSize = set.size();
        int[] aa = new int[setSize];
        int ii = 0;
        int count = 0;
        Set<Integer> AA = new TreeSet<>();
        Set<Integer> BB = new TreeSet<>();
        for (Integer key : set){
            aa[ii] = key;
            ii ++;
        }

        for (int i = 0; i < len; i++) {
            int a = A[i];
            int b = B[i];
            AA.clear();
            BB.clear();
            //在素数中找出能被a整除的数
            for (int j = 0; j < setSize; j++) {
                int c = aa[j];
                if(a % c == 0){
                    AA.add(c);
                }
                if(b % c == 0){
                    BB.add(c);
                }
            }
            if(AA.equals(BB)){
                count ++;
            }
        }
        return count;
    }

    public static Set<Integer> primes (int N){
        Set<Integer> set = new TreeSet<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)){
                set.add(i);
            }
        }
        return set;
    }

    public static boolean isPrime(int N){
        if(N == 2){
            return true;
        }
        for (int i = 2; i < N; i++) {
            if(N % i == 0){
                return false;
            }
        }
        return true;
    }

    public static int getMax(int[] A,int[] B){
        int len = A.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if(A[i] > max){
                max = A[i];
            }
            if(B[i] > max){
                max = B[i];
            }
        }
        return (int) Math.sqrt(max);
    }
}
