package com.jhlc.second.second.saunfa;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by licheng on 30/12/15.
 */
public class Fish {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,7,8,9,10,4,3,2,1};
        int[] B = {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(solution(A,B));
    }

    //37分 https://codility.com/demo/results/training9ZNPAH-Q75/
    public static int solution(int[] A,int[] B){
        int a = B[0];
        int b = 0;
        int length = A.length;
        Map<Integer,Integer> map = new HashMap<>();
        Stack<fish> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            map.put(A[i],B[i]);
        }

        //初始化栈
        for(int i = 1; i < length; i ++){
            if(B[i] != a) b = i;break;
        }

        for(int i = 0; i < b + 1; i ++){
            stack.push(new fish(A[i],map.get(A[i])));
        }

        for (int i = b + 1; i <length ; i++) {
            if(map.get(A[i]) == stack.peek().upordown){
                stack.push(new fish(A[i],map.get(A[i])));
            }else if(A[i] < stack.peek().size){
                    continue;
            }else {
                stack.pop();
                stack.push(new fish(A[i],map.get(A[i])));
            }
        }
        return stack.size();
    }

    public static class fish{

        public fish(int size, int upordown) {
            this.size = size;
            this.upordown = upordown;
        }

        private int size = 1;
        private int upordown = 0;

    }

    public static void printStack(Stack<fish> stack,String type){
        for(int j = 0; j < stack.size(); j ++){
            System.out.print(stack.get(j).size+" ");
        }
        System.out.println(type);
    }
}
