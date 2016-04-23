package datastruct.ErChaShu.MaoPao;

public class Main {

    static int SIZE=10;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] shuzhu=new int[SIZE];
        int i;

        for(i=0;i<SIZE;i++){
            shuzhu[i]=(int)(20+(50-20)*Math.random());
        }

        System.out.print("排序前的数组为：\n");
        for(i=0;i<SIZE;i++){
            System.out.print(shuzhu[i]+" ");
        }
        System.out.print("\n");
        MaoPao maoPao = new MaoPao();
        maoPao.bubbleSort(shuzhu);
        System.out.print("排序后的数组为：");
        for(i=0;i<SIZE;i++){
            System.out.print(shuzhu[i]+" ");
        }
        System.out.print("\n");
    }
}
