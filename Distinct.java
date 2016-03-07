package com.jhlc.second.second.saunfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by licheng on 24/12/15.
 */
public class Distinct {
    public static void main(String[] args) {
        int[] str = {2,1,1,2,3,1};
        System.out.println(solution(str));
    }

    //100分 https://codility.com/demo/results/trainingKQX4GC-22X/
    public static int solution(int[] A){
        int length = A.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++){
            map.put(A[i],1);
        }
        return map.size();
    }
}
