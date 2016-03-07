package com.jhlc.second.second.saunfa;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by licheng on 31/12/15.
 */
public class Dominator {
    public static void main(String[] args) {
        int[] A = {3,4,3,2,3,-1,3,3,2,2,2,2,2,2,2};
        System.out.println(solution(A));
    }

    //100分 https://codility.com/demo/results/trainingB2N2FY-BWC/
    public static int solution(int[] A){
        int length = A.length;
        int half = length / 2;
        int numoccursmore = 0;
        int index = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = A[i];
            int occurs = 1;
            if(map.containsKey(num)){
                occurs = map.get(num) + 1;
            }
            map.put(num,occurs);
            if(occurs > half && occurs > numoccursmore){
                index = i;
                numoccursmore = occurs;
            }
        }
        return index;
    }

    public static int solution1(int[] A) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int half = A.length/2;
        int dominatorNumOccurs = 0;
        int dominatorIdx = -1;

        for(int i = 0;i<A.length;i++){
            int num = A[i];
            int occurs = 1;
            if(hashMap.containsKey(num))
                occurs = hashMap.get(num)+1;
            hashMap.put(num, occurs);
            if(occurs > half && occurs > dominatorNumOccurs){
                dominatorIdx = i;
                dominatorNumOccurs = occurs;
            }
        }

        return dominatorIdx;
    }
}
