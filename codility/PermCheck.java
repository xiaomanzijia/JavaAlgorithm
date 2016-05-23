package com.jhlc.second.second.saunfa;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by licheng on 23/12/15.
 */
public class PermCheck {
    public static void main(String[] args) {
        int[] str = {4,1,3,2};
        System.out.println(solution(str));
        System.out.println(solution1(str));
    }
    public static int solution(int[] A){
        int length = A.length;
        int lengthB = length+1;
        int ii = 0;
        if(length==0||length==1){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int C[] = new int[length];
        int B[] = new int[lengthB];
        for(int i = 0; i < lengthB; i ++){
            B[i]=i+1;
            if(i<length){
                map.put(A[i],1);
            }
        }

        for(Integer key:map.keySet()){
            C[ii]=key;
            ii++;
        }

        if(B[lengthB-2]==C[length-1]){
            return 1;
        }else {
            return 0;
        }
    }

    public static int solution1(int[] A){
        int length = A.length;
        int sum = 0;
        int shouldSum = 0;
        for(int i = 0 ; i < length+1; i ++){
            if(i<length){
                sum += A[i];
            }
            shouldSum = shouldSum+i+1;
        }
        if(shouldSum==sum){
            return 1;
        }else {
            return 0;
        }
    }
}
