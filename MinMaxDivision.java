/**
 * Created by licheng on 3/4/16.
 */
public class MinMaxDivision {
    public static void main(String[] args) {
        int K = 3;
        int M = 5;
        int[] A = {2,1,5,1,2,2,2};

        System.out.println(solution(K,M,A));
    }

    public static int solution(int K, int M, int[] A){
        int len = A.length;
        int sum = sum(A);
        int sum1 = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            sum1 += A[i];
            int sum2 = 0;
            for (int j = i + 1; j < len - i ; j++) {
                sum2 += A[j];
                int sum3 = sum - sum1 - sum2;
                int max = max(sum1,sum2,sum3);
                if(max < min){
                    min = max;
                }
            }
        }
        return min;
    }

    public static int sum(int[] A){
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

    public static int max(int a, int b, int c){
        int max =  a > b ? a : b;
        return c > max ? c : max;
    }
}
