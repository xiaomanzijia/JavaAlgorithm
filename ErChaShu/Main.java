package datastruct.ErChaShu;

import java.util.Scanner;

public class Main {
    private static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {

        CBTType root=null;      //定义一个二叉树
        int menusel;
        P2_5 t = new P2_5();        //引用二叉树数据结构
        root=t.InitTree();      //初始化二叉树
        do{
            System.out.print("请选择菜单添加二叉树的结点\n");
            System.out.printf("0.退出\n");
            System.out.printf("1.添加二叉树的结点\n");
            menusel=input.nextInt();
            switch (menusel){
                case 1:
                    t.AddTreeNode(root);
                    break;
                case 0:
                    break;
                default:
                    ;
            }
        }while (menusel!=0);

        do{
            System.out.printf("请选择菜单遍历二叉树，输入0表示退出：\n");
            System.out.printf("1.先序遍历DLR\t");
            System.out.printf("2.中序遍历DLR\t");
            System.out.printf("3.后序遍历DLR\t");
            menusel=input.nextInt();
            switch (menusel){
                case 0:
                    break;
                case 1:
                    System.out.print("\n先序遍历DLR的结果：");
                    t.DLRTree(root);
                    System.out.printf("\n");
                    break;
                case 2:
                    System.out.print("\n中序遍历DLR的结果：");
                    t.LDRTree(root);
                    System.out.printf("\n");
                    break;
                case 3:
                    System.out.print("\n后序遍历DLR的结果：");
                    t.LRDTree(root);
                    System.out.printf("\n");
                    break;
                default:
                    ;
            }
        }while (menusel!=0);

        System.out.printf("\n二叉树深度为：%d\n", t.TreeDepth(root));
        t.ClearTree(root);
        root=null;
    }
}
