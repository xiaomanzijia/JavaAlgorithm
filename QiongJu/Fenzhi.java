package datastruct.ErChaShu.QiongJu;

/**
 * Created by Administrator on 2015/4/4.
 */
public class Fenzhi {
    static final int MAXNUM=30;
    static int FalseCoin(int coin[],int low,int high){
        int i,sum1,sum2,sum3;
        int re=0;
        sum1=sum2=sum3=0;
        //相邻数
        if(low+1==high){
            if(coin[low]>coin[high]){
                re = high;
            }else{
                re=low;
            }
            return re;
        }else{
            //奇数
            if((high-low)%2==0){
                //前半部分
                for(i=low;i<(low+high)/2;i++){
                    sum1+=coin[i];
                }
                //后半部分
                for(i=(low+high)/2+1;i<high;i++){
                    sum2+=coin[i];
                }
                sum3=coin[(low+high)/2];
                if(sum1>sum2){
                    re=FalseCoin(coin,(low+high)/2+1,high);
                    return re;
                }
                if(sum1<sum2){
                    re = FalseCoin(coin,low,(low+high)/2-1);
                    return re;
                }
                if(sum1==sum2){
                    re=coin[(low+high)/2];
                    return re;
                }
              //偶数
            } else{
                for(i=0;i<low+(high-low)/2;i++){
                    sum1+=coin[i];
                }
                for(i=low+(high-low)/2;i<=high;i++){
                    sum2+=coin[i];
                }
                if(sum1>sum2){
                    re=FalseCoin(coin,low+(high-low)/2+1,high);
                    return re;
                }
                if(sum1<sum2){
                    re=FalseCoin(coin,low,low+(high-low)/2);
                    return re;
                }
                if(sum1==sum2){

                }
            }
        }
        return re;
    }
}
