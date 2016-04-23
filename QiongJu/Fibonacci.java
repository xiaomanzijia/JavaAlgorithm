package datastruct.ErChaShu.QiongJu;

/**
 * Created by Administrator on 2015/4/4.
 */
public class Fibonacci {

    public static int fibonacci(int n){
        int t1,t2;
        if(n==1||n==2){
            return 1;
        }
        else {
            t1=fibonacci(n-1);
            t2=fibonacci(n-2);
            return t1+t2;
        }
    }

    public static int JieChen(int n){
        if(n==1){
            return 1;
        }
        else
        {
            return n*JieChen(n-1);
        }
    }
}
