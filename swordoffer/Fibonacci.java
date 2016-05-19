package datastruct.ErChaShu.swordoffer;

/**
 * Created by licheng on 19/5/16.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(Fibonacci(8));
    }
    public static int Fibonacci(int n){
        int a = 1;
        int b = 1;
        int c = 0;
        if(n == 0 || n == 1){
            return 1;
        }
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
