package datastruct.ErChaShu.Graph;

import sun.security.provider.certpath.Vertex;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Administrator on 2015/4/1.
 */
public class P2_6 {
    static Scanner input = new Scanner(System.in);

    static void CreateGraph(GraphMatrix GM){
        int i,j,k;
        int weight; //权
        char EstartV,EendV; //边的起始顶点

        System.out.printf("输入图中各顶点信息\n");
        for (i=0;i<GM.VertexNum;i++){                   //输入顶点
            System.out.printf("第%d个顶点：", i + 1);
            GM.Vertex[i]=(input.next().toCharArray())[0];       //保存各定点元素到数组
        }
        System.out.printf("输入构成各边的顶点及权值：\n");
        for(k=0;k<GM.EdgeNum;k++){                          //输入边
            System.out.printf("第%d条边：", k + 1);
            EstartV=input.next().charAt(0);
            EendV=input.next().charAt(0);
            weight=input.nextInt();
            for(i=0;EstartV!=GM.Vertex[i];i++);         //在已有顶点中查找开始点
            for(j=0;EendV!=GM.Vertex[j];j++);           //在已有顶点中查找终结点
            GM.EdgeWeight[i][j]=weight;                 //对应保存权值，表示有一条边
            if(GM.GType==0){
                GM.EdgeWeight[j][i]=weight;             //在对角位置保存权值
            }
        }
    }

    static void ClearGraph(GraphMatrix GM){                 //清空矩阵
        int i,j;
        for(i=0;i<GM.VertexNum;i++){
            for(j=0;j<GM.VertexNum;j++){
                GM.EdgeWeight[i][j]=GraphMatrix.MaxValue;       //设置矩阵各元素值为MaxValue
            }
        }
    }

    static void OutGraph(GraphMatrix GM){               //输出邻接矩阵
        int i,j;
        for (j=0;j<GM.VertexNum;j++){
            System.out.printf("\t%c", GM.Vertex[j]);        //在第一行输出顶点信息
        }
        System.out.printf("\n");
        for(i=0;i<GM.VertexNum;i++){
            System.out.printf("%c", GM.Vertex[i]);
            for (j=0;j<GM.VertexNum;j++){
                if(GM.EdgeWeight[i][j]==GraphMatrix.MaxValue){      //若权值为最大
                    System.out.printf("\tZ");       //以Z表示无穷大
                }
                else
                {
                    System.out.printf("\t%d",GM.EdgeWeight[i][j]);  //输出边的权值
                }
            }
            System.out.printf("\n");
        }
    }

    static void DeepTraOne(GraphMatrix GM,int n){               //从第n个结点开始深度遍历
        int i;
        GM.isTrav[n]=1;                                             //标记该顶点已处理过
        System.out.printf("->%c",GM.Vertex[n]);                     //输出结点数据

        for(i=0;i<GM.VertexNum;i++){
            if(GM.EdgeWeight[n][i]!=GraphMatrix.MaxValue&&GM.isTrav[n]==0){
                DeepTraOne(GM,i);                                       //递归进行遍历
            }
        }
    }

    static void DeepTraGraph(GraphMatrix GM){           //深度优先遍历
        int i;
        for(i=0;i<GM.VertexNum;i++){                    //清除各顶点遍历标志
            GM.isTrav[i]=0;
        }
        System.out.printf("深度优先遍历结点：");
        for(i=0;i<GM.VertexNum;i++){
            if(GM.isTrav[i]==0){                        //若该点未遍历
                DeepTraOne(GM,i);                           //调用函数遍历
            }
        }
        System.out.printf("\n");
    }
}
