package datastruct.ErChaShu.Graph;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
//        System.out.println("Hello World!");
        GraphMatrix GM = new GraphMatrix();
        P2_6 p = new P2_6();
        System.out.printf("输入生成图的类型：");
        GM.GType=input.nextInt();
        System.out.printf("输入图的顶点数量：");
        GM.VertexNum=input.nextInt();
        System.out.printf("输入图边的数量：");
        GM.EdgeNum=input.nextInt();
        p.ClearGraph(GM);
        p.CreateGraph(GM);
        System.out.printf("该图的邻接矩阵数据如下：\n");
        p.OutGraph(GM);
//        p.DeepTraGraph(GM);
    }

}
