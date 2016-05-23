package datastruct.ErChaShu.Graph;

/**
 * Created by Administrator on 2015/4/1.
 */
public class GraphMatrix {
    static final int MaxValue=65535;        //保存特殊符号Z的最大值
    static final int MaxNum=20;             //图的最大顶点数
    char[] Vertex=new char[MaxNum];     //保存顶点信息
    int GType;      //图的类型（0： 无向图，1：有向图）
    int VertexNum;      //顶点的数量
    int EdgeNum;        //边的数量
    int [][]EdgeWeight = new int[MaxNum][MaxNum];       //保存边的权
    int[] isTrav = new int[MaxNum];     //遍历标志
}
