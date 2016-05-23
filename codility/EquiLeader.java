package com.jhlc.second.second.saunfa;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by licheng on 31/12/15.
 */
public class EquiLeader {
    public static void main(String[] args) {
        int[] A = {4,3,4,4,4,2};
        System.out.println(solution(A));
    }

    //66分 https://codility.com/demo/results/trainingBFMY8V-AGJ/
    public static int solution(int[] A){
        int length = A.length;
        Leader leaderclass = getLeader(A);
        int leader = leaderclass.value;
        int count = 0;
        int a = 0;
        for (int i = 0; i < length; i++) {
            if(A[i] == leader){
                count ++;
            }
            int b = (i + 1) / 2;
            int c = (length - i -1) / 2;
            if(count > b && (leaderclass.ocurrences - count) > c){
                a ++;
            }
        }
        return a;
    }

    public static class Leader {
        int ocurrences;
        int value;
        public Leader(int value, int ocurrences) {
            this.value = value;
            this.ocurrences = ocurrences;
        }
    }

    public static Leader findLeader(int[] A){
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
        return new Leader(A[index],numoccursmore);
    }

    public static Leader getLeader(int[] A) {
        int stackCounter = 0, candidate=-1, value=-1;

        for(int element: A ) {
            if (stackCounter == 0) {
                value = element;
                ++stackCounter;
            } else {
                if (value == element) {
                    ++stackCounter;
                } else {
                    --stackCounter;
                }
            }
        }

        if (stackCounter > 0 ) {
            candidate = value;
        } else {
            return null;
        }

        int countRepetitions = 0;
        for (int element: A) {
            if( element == candidate) {
                ++countRepetitions;
            }
        }

        if(countRepetitions > (A.length / 2)) {
            return new Leader(candidate, countRepetitions);
        }
        return null;
    }
}
