package com.jhlc.second.second.saunfa;

import java.util.Scanner;

/**
 * Created by licheng on 21/1/16.
 */
public class Change {
    private static final int[] m = {100,50,20,10,5,2,1};
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int f = scanner.nextInt();
        int[] amount = new int[f];
        for(int i = 0 ; i < f;i++){
            amount[i] = giveChange(scanner.nextInt());
        }
    }

    public static int giveChange(int n)  {
        int num=0;
        int a = 0;
        for(int i=0;i<m.length;i++){
            a = n/m[i];
            num+=n/m[i];
            n=n%m[i];
            if(a != 0){
                System.out.println(a+"张"+m[i]+"元");
            }
        }
        System.out.println("总共"+num+"张");
        return num;
    }
}
