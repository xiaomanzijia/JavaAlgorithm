package com.jhlc.second.second.saunfa;

/**
 * Created by licheng on 23/12/15.
 */
public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(soluiton(12,73,13));
        System.out.println(solution2(12,73,13));
    }

    //15分
    public static int soluiton(int X, int Y, int D){
        int first = X;
        int count = 0;
        if(D==0&&X+D<Y||(D==0&&X+D>Y)){
            return 0;
        }else{
            for(int i = 0 ;;i++){
                first += D;
                if(first >= Y){
                    count = i + 1;
                    break;
                }
            }
        }
        return count;
    }

    //100分
    public static  int solution2(int X,int Y,int D) {
        if(D==0&&X+D<Y||(D==0&&X+D>Y)){
            return 0;
        }

        if((Y-X)%D==0){
            return (Y-X)/D;
        }else {
            return  (Y-X)/D+1;
        }
    }
}
