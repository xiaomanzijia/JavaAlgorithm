package datastruct.ErChaShu.LianBiao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        CLType node,head=null;
        CLType CL = new CLType();
        String key,findkey;
        Scanner input = new Scanner(System.in);

        System.out.print("测试链表。先输入链表中的数据，格式为：关键字 姓名 年龄\n");
        do{
            DATA2 nodeData = new DATA2();
            nodeData.key=input.next();
            if(nodeData.key.equals("0")){
                break;                  //若输入0，则推出
            }else{
                nodeData.name=input.next();
                nodeData.age=input.nextInt();
                head=CL.CLAddEnd(head,nodeData);           //在链表尾部添加结点
            }
        }while (true);
        CL.CLAllNode(head);                                //显示所有结点

        System.out.print("演示插入结点，输入插入位置的关键字:\n");
        findkey=input.next();
        System.out.print("输入插入结点的数据（关键字 姓名 年龄）:\n");
        DATA2 nodeData = new DATA2();
        nodeData.key=input.next();
        nodeData.name=input.next();
        nodeData.age=input.nextInt();
        head.CLInsertNode(head,findkey,nodeData);
        CL.CLAllNode(head);


    }
}







