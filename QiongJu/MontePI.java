package datastruct.ErChaShu.QiongJu;

/**
 * Created by Administrator on 2015/4/4.
 */
public class MontePI{
    static double MontePI(int n){
        double PI;
        double x,y;
        int i,sum;
        sum=0;
        for(i=0;i<n;i++){
            x=Math.random();
            y=Math.random();
            if(x*x+y*y<=1){
                sum++;
            }
        }
        PI=4.0*sum/n;
        return PI;
    }
}
