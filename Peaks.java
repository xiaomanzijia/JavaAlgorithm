package com.jhlc.second.second.saunfa;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by licheng on 4/1/16.
 */
public class Peaks {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,3,4,1,2,3,4,6,2};
        int[] B ={1,2,3,4,5,6,5,5,5,6,5,6};
        printMap(peekNums(A));
        System.out.println(solution2(A));
    }

    //36分 https://codility.com/demo/results/trainingTNW994-A6P/
    public static int solution2(int[] A){
        int len = A.length;
        int b = 0;
        int countAll = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map = peekNums(A);
        for (int i = len / map.size(); i <= len; i++) {
            if(len % i == 0){
                int count = 0;
                for (int j = 1; j <= len / i; j++) {
                    int a = i * j;
                    for (int z = a -i; z < a; z ++){
                        if(map.containsKey(z)){
                            count ++;
                            break;
                        }
                    }
                    b = j;
                }
                System.out.println(b + " "+ count);
                if(count == b){
                    countAll ++;
                }
            }
        }
        return countAll;
    }


    public static int solution(int[] A){
        int len = A.length;
        int b = 0;
        int countAll = 0;
        for (int i = 3; i <= len; i++) {
            if(len % i == 0){
                int count = 0;
                for (int j = 1; j <= len / i; j++) {
                    int[] B = new int[i];
                    int a = i * j;
                    for (int z = a - i; z < a; z++) {
                        B[z % i] = A[z];
                    }
                    print(B);
                    if(hasPeekNum(B)){
                        count ++;
                    }
                    b = j;
                }
                System.out.println(b + " "+ count);
                if(count == b){
                    countAll ++;
                }
            }
        }
        return countAll;
    }


    public static void print(int[] A){
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }


    public static void printMap(Map<Integer,Integer> map){
        for(Integer key : map.keySet()){
            System.out.println(key+" "+ map.get(key)+" ");
        }
    }

    public static Map<Integer,Integer> peekNums(int[] A){
        Map<Integer,Integer> map = new HashMap<>();
        int len = A.length;
        for (int i = 1; i < len - 1; i++) {
            if(A[i] > A[i + 1] && A[i] > A[i - 1]){
                map.put(i,A[i]);
            }
        }
        return map;
    }

    public static boolean hasPeekNum(int[] A){
        int len = A.length;
        int count = 0;
        for (int i = 1; i < len - 1; i++) {
            if(A[i] > A[i + 1] && A[i] > A[i - 1]){
                count ++;
            }
        }
        return count > 0 ? true : false;
    }
}
