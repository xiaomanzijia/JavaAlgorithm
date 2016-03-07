package com.jhlc.second.second.saunfa;

/**
 * Created by licheng on 24/12/15.
 */
public class GenomicRangeQuery {
    public static void main(String[] args) {
        String s = "CAGCCTA";
        int[] p = {2,5,0};
        int[] q = {4,5,6};
//        solution(s,p,q);
        for(int i = 0 ; i < p.length; i ++){
            System.out.print(solution(s,p,q)[i]+" ");
        }
    }

    //62分 https://codility.com/demo/results/training8WM572-W7Z/
    public static int[] solution(String S, int[] P, int[] Q){
        int length = P.length;
        int Slength = S.length();
        int[] s = new int[Slength];
        int[] results = new int[length];
        int f = 0;
        int l = 0;
        String sss = S.replace("A","1").replace("C","2").replace("G","3").replace("T","4");
        for(int i = 0 ; i < Slength; i ++){
            char c = sss.charAt(i);
            int ss = Integer.parseInt(c+"");
            s[i]= ss;
        }
        for(int i = 0; i < length; i ++){
            f = P[i];
            l = Q[i];
            int min = Integer.MAX_VALUE;
            for(int j = f; j <=l ; j ++){
                if(s[j]<min) min = s[j];
            }
            results[i] = min;
        }
        return results;
    }
}
