package datastruct.ErChaShu.LianBiao;

import javax.swing.plaf.SliderUI;

/**
 * Created by Administrator on 2015/3/29.
 */
public class CLType {
    DATA2 noteData = new DATA2();
    CLType nextNode;

    //追加结点
    CLType CLAddEnd(CLType head,DATA2 noteData){
        CLType node,htemp;
        if((node=new CLType())==null){
            System.out.print("申请内存失败！\n");
            return null;
        }else{
            node.noteData=noteData;
            node.nextNode=null;
            if(head==null){
                head=node;
                return head;
            }
            htemp=head;
            while (htemp.nextNode!=null)
            {
                htemp=htemp.nextNode;
            }
            htemp.nextNode=node;
            return head;
        }
    }

    //插入头结点
    CLType CLAddFirst(CLType head,DATA2 noteDatae){
        CLType node;
        if((node = new CLType())==null){
            System.out.print("申请内存失败！\n");
            return null;
        }else{
            node.noteData=noteDatae;
            node.nextNode=head;
            head=node;                       //注意：node没有nextNode,head本身就相当于head.nextNode
            return head;
        }
    }

    //查找结点
    CLType CLFindNode(CLType head,String key){
        CLType htemp;
        htemp=head;                           //保存链表头引用
        while (htemp!=null){
            if(htemp.noteData.key.compareTo(key)==0){
                return htemp;
            }
            htemp=htemp.nextNode;            //htemp就相当于htemp所指向的node
        }
        return null;
    }

    //插入结点
    CLType CLInsertNode(CLType head,String findkey,DATA2 noteData){
        CLType nodetemp,node;
        if((node=new CLType())==null){
            System.out.print("申请内存失败！\n");
            return null;
        }
            node.noteData=noteData;
            nodetemp=CLFindNode(head,findkey);
            if(nodetemp!=null){
                node.nextNode=nodetemp.nextNode;
                nodetemp.nextNode=node;
            }else{
                System.out.print("未找到正确的插入位置！\n");
//                free(head);                 //释放内存
            }
            return head;
    }

    //删除结点
    int CLDeleteNode(CLType head,String key){
        CLType node,htemp;                  //node保存删除结点的前一结点
        htemp=head;
        node=head;
        while (htemp!=null){
            if(htemp.noteData.key.compareTo(key)==0){
                node.nextNode=htemp.nextNode;
//                free(htemp);              //释放内存
                return 1;
            }else{
                node=htemp;
                htemp=htemp.nextNode;
            }
        }
        return 0;
    }

    //计算链表长度
    int CLLength(CLType head){
        CLType htemp;
        int Len=0;
        htemp=head;
        while (htemp!=null){
            Len++;
            htemp=htemp.nextNode;
        }
        return Len;
    }

    //遍历链表
    void CLAllNode(CLType head){
        CLType htemp;
        DATA2 nodeData;
        htemp=head;
        System.out.printf("当前链表共有%d个结点。链表所有数据如下：\n", CLLength(head));
        while (htemp!=null){
            nodeData=htemp.noteData;
            System.out.printf("结点（%s，%s，%d）\n",nodeData.key,nodeData.name,nodeData.age);
            htemp=htemp.nextNode;
        }
    }

































}
