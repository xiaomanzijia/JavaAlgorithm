package datastruct.ErChaShu.QiongJu;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int heads,foots,num;
        QJ qj = new QJ();
        Fibonacci fibo = new Fibonacci();
        Fenzhi fenzhi = new Fenzhi();
        MontePI montePI = new MontePI();
        int coin[] = new int[30];
        int i,n;
        int weizhi;
	// write your code here
        System.out.print("请输入头的数量：");
        heads=input.nextInt();
        System.out.print("请输入脚的数量：");
        foots=input.nextInt();
        qj.Total(heads,foots);
        System.out.print("------------\n");
        System.out.print("递推算法");
        System.out.print("请输入一个自然数：");
        num = input.nextInt();
        System.out.printf("斐波那契数计算结果为：%d\n", fibo.fibonacci(num));
        System.out.print("------------\n");
        System.out.print("请输入一个自然数：");
        num = input.nextInt();
        System.out.printf("递归算法计算%d的阶乘结果为：%d\n", num, fibo.JieChen(num));
        System.out.print("------------\n");
        System.out.print("分治算法求解假币问题\n");
        System.out.printf("请输入硬币总的个数：");
        num=input.nextInt();
        System.out.print("请输入硬币的真假：\n");
        for (i=0;i<num;i++){
            coin[i]=input.nextInt();
        }
        weizhi = fenzhi.FalseCoin(coin,0,num-1);
        System.out.printf("在上述%d个硬币中，第%d位置的硬币是假币！\n", num, weizhi);
        System.out.print("------------\n");
        System.out.print("蒙特卡罗概率方法求解PI\n");
        System.out.print("输入点的数量：");
        num=input.nextInt();
        System.out.print("PI="+montePI.MontePI(num));
    }
}
