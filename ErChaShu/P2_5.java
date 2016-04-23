package datastruct.ErChaShu;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Administrator on 2015/3/31.
 */
public class P2_5 {
    static final int MAXLEN=20;
    static Scanner input = new Scanner(System.in);
    CBTType InitTree(){                                     //初始化二叉树的根
        CBTType node;
        if((node=new CBTType())!=null){                     //申请内存
            System.out.print("请先输入一个根节点数据：\n");
            node.data=input.next();
            node.left=null;
            node.right=null;
            if(node!=null){                                 //如果二叉树根节点不为空
                return node;
            }else {
                return null;
            }
        }
        return null;
    }

    void AddTreeNode(CBTType treeNode){                     //添加结点
        CBTType pnode,parent;
        String data;
        int menusel;
        if((pnode=new CBTType())!=null){                    //分配内存
            System.out.print("输入二叉树结点数据：\n");
            pnode.data=input.next();
            pnode.left=null;
            pnode.right=null;                               //设置左右子树为空

            System.out.print("输入该结点的父结点数据：");
            data=input.next();

            parent=TreeFindNode(treeNode,data);             //查找指定的数据结点
            if(parent==null){
                System.out.print("未找到该父结点！\n");
                pnode=null;                                 //释放创建的结点内存
                return;
            }

            System.out.print("1、添加结点到左子树\n2、添加结点到右子树\n");
            do{
                menusel=input.nextInt();                //输入选择项
                if(menusel==1||menusel==2){
                    if(parent==null){
                        System.out.print("不存在父结点，请先设置父结点！\n");
                    }else{
                        switch (menusel){
                            case 1:                                     //添加到左子树
                                if(parent.left!=null){                  //左子树不为空
                                    System.out.print("左子树结点不为空！\n");
                                }else {
                                    parent.left=pnode;
                                }
                                break;
                            case 2:
                                if(parent.right!=null){
                                    System.out.print("右子树结点不为空！\n");
                                }else{
                                    parent.right=pnode;
                                }
                                break;
                            default:
                                System.out.print("参数无效！\n");
                        }
                    }
                }
            }while (menusel!=1&&menusel!=2);
        }
    }

    CBTType TreeFindNode(CBTType treeNode,String data){
        CBTType ptr;
        if(treeNode==null){
            return null;
        }else{
            if(treeNode.data.equals(data)){
                return treeNode;
            }else{                      //分别向左右子树进行递归查找
                if((ptr=TreeFindNode(treeNode.left,data))!=null){
                    return ptr;
                }else if((ptr=TreeFindNode(treeNode.right,data))!=null)
                    {
                        return ptr;
                    }else {
                    return null;
                }
                }
            }
        }

    CBTType TreeLeftNode(CBTType treeNode){             //获取左子树
        if(treeNode!=null){
            return treeNode.left;
        }else {
            return null;
        }
    }

    CBTType TreeRightNode(CBTType treeNode){             //获取左子树
        if(treeNode!=null){
            return treeNode.right;
        }else {
            return null;
        }
    }


    int TreeIsEmpty(CBTType treeNode){
        if(treeNode!=null)
        {
            return 0;
        }else {
            return 1;
        }
    }

    int TreeDepth(CBTType treeNode){
        int depLeft,depRight;
        if(treeNode==null){
            return 0;
        }
        else {
            depLeft=TreeDepth(treeNode.left);               //左子树深度（递归调用）
            depRight=TreeDepth(treeNode.right);             //右子树深度（递归调用）
            if(depLeft>depRight){
                return depLeft+1;
            }else {
                return depRight+1;
            }
        }
    }

    void ClearTree(CBTType treeNode){
        if(treeNode!=null){
            ClearTree(treeNode.left);
            ClearTree(treeNode.right);
            treeNode=null;
        }
    }

    void TreeNodeData(CBTType p){
        System.out.printf("%s", p.data);
    }

    void DLRTree(CBTType treeNode){             //先序遍历
        if(treeNode!=null){
         TreeNodeData(treeNode);
            DLRTree(treeNode.left);
            DLRTree(treeNode.right);
        }
    }

    void LDRTree(CBTType treeNode){             //中序遍历
        if(treeNode!=null){
            LDRTree(treeNode.left);
            TreeNodeData(treeNode);
            LDRTree(treeNode.right);
        }
    }

    void LRDTree(CBTType treeNode){             //后序遍历
        if(treeNode!=null){
            LRDTree(treeNode.left);
            LRDTree(treeNode.right);
            TreeNodeData(treeNode);
        }
    }

    }
