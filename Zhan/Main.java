package datastruct.ErChaShu.Zhan;

import com.sun.deploy.util.SyncAccess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        StackType st = new StackType();
        DATA3 getData = new DATA3();

        StackType stack = st.STInit();
        Scanner input = new Scanner(System.in);
        System.out.print("入栈操作：\n");
        System.out.print("输入姓名 年龄进行入栈操作：\n");
        do{
            DATA3 data = new DATA3();
            data.name=input.next();
            if(data.name.equals("0")){
                break;
            } else{
              data.age=input.nextInt();
                st.PushST(stack,data);
            }
        }while (true);

        String temp="1";
        System.out.println("出栈操作：按任意非0键进行出栈操作：");
        temp=input.next();
        while (!temp.equals("0")){
            getData = st.PopST(stack);
            System.out.printf("出栈的数据是（%s,%d）\n", getData.name, getData.age);
            temp=input.next();
        }
        System.out.print("测试结束！");
        st.STFree(st);


    }
}
