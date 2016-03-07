package com.jhlc.second.second.saunfa;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by licheng on 7/1/16.
 */
public class CountSemiprimes {
    public static void main(String[] args) {
        int[] P = {1,4,16,34,56,23};
        int[] Q = {26,10,20,100,50,87};
        int N = 100;
        int len = P.length;
        for (int i = 0; i < len; i++) {
            System.out.print(solution(N,P,Q)[i] + " ");
        }
    }
    //55分 https://codility.com/demo/results/trainingGY6JFU-UV4/
    public static int[] solution(int N, int[] P, int[] Q){
        int lenP = P.length;
        int[] results = new int[lenP];
        Set<Integer> setA = primes(N);
        int len = setA.size();
        int[] A = new int[len];
        Set<Integer> setB = new TreeSet<>();
        int i = 0;
        for (Integer key : setA){
            A[i] = key;
            i ++;
        }
        int[] B = A.clone();
        for (int j = 0; j < len; j++) {
            for (int z = 0; z < len; z ++){
                int a = A[j] * B[z];
                setB.add(a);
            }
        }
        for (int jj = 0; jj < lenP; jj++) {
            int aa = P[jj];
            int bb = Q[jj];
            int count = 0;
            for (int zz = aa; zz <= bb; zz++) {
                if(setB.contains(zz)){
                    count ++;
                }
            }
            results[jj] = count;
        }
        return results;
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
}
