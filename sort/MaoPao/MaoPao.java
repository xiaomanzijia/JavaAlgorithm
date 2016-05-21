package datastruct.ErChaShu.MaoPao;

/**
 * Created by Administrator on 2015/4/12.
 */
public class MaoPao {
    public void bubbleSort(int[] a){
        int temp;
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
            System.out.print("第"+i+"步排序结果：");
            for(int k=0;k<a.length;k++){
                System.out.print(" "+a[k]);
            }
            System.out.print("\n");
        }

    }
}
