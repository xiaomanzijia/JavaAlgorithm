package datastruct.ErChaShu;

/**
 * Created by licheng on 18/5/16.
 */
//剑指offer:二位数组中的查找
public class Find {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(find(array,7));
        System.out.println(Find(array,14));
    }

    //高效率算法
    public static boolean find(int[][] array, int n){
        if(array == null){
            return false;
        }
        int column = array[0].length - 1;
        int row = 0;
        while (row < array.length && column > 0){
            if(array[row][column] == n){
                return true;
            }
            if(array[row][column] > n){
                column -- ;
            }else {
                row ++;
            }
        }
        return false;
    }

    //普通的二维数组扫描
    public static boolean Find(int[][] array, int n){
        if(array == null) {
            return false;
        }
        int row = array.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if(array[i][j] == n){
                    return true;
                }
            }
        }
        return false;
    }
}
