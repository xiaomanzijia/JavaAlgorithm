package com.jhlc.second.second.saunfa;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by licheng on 22/12/15.
 */
//如果数组中数字重复最多的次数大于数组长度的一半，返回1，否则返回-1
public class TestOne {
    public static void main(String[] args) {
        int[] str = {5,5,5,5,5,5,5,5,5,5,5,5,4,4,4,6,4,6,3,7};
        System.out.println(solution(str));
    }

    public static int solution(int[] A){
        int L = A.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < L  ; i ++){
            map.put(A[i],0);
        }
        int M = map.size();
        int Amid = L / 2;
        int i = 0;
        int count = 0;
        int[] B = new int[M];
        int[] compirecounts = new int[M];
        for(Integer key : map.keySet()){
                B[i] = key;
                i++;
            }

        for(int j = 0;j<M;j++){
            count = 0;
            for(int k = 0; k < A.length;k++){
                if(B[j]==A[k]){
                    count++;
                }
            }
            compirecounts[j]=count;
        }


        if(getMax(compirecounts)>Amid){
            return 1;
        }else {
            return -1;
        }
    }

    public static int getMax(int[] A){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < A.length;i++){
            if(A[i]>max) max=A[i];
        }
        return max;
    }
}
