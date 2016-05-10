package datastruct.ErChaShu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by licheng on 10/5/16.
 */
//https://codility.com/demo/results/training2YRUZ9-YQQ/ 30fen
public class CountDistinctSlices {
    public static void main(String[] args) {
        int m = 6;
        int[] A = {3,4,5,5,2};
        System.out.println(solution(m,A));
    }

    public static int solution(int M, int[] A){
        for (int i = 0; i < A.length; i++) {
            if(A[i] >= M){
                return -1;
            }
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                Set<Integer> set = new HashSet<Integer>();
                for (int k = i; k <= j; k++) {
                    set.add(A[k]);
                }
                if(set.size() == (j - i +1)){
                    count ++;
                }
            }
        }
        return count + A.length;
    }
}
