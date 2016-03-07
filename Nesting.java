package com.jhlc.second.second.saunfa;

import java.util.Stack;

/**
 * Created by licheng on 26/12/15.
 */
public class Nesting {
    public static void main(String[] args) {
        String s = ")()(";
        System.out.println(solution3(s));
    }

    //100分 https://codility.com/demo/results/trainingF2SPC5-JFS/
    public static int solution3(String S){
        int length = S.length();
        int result = 0;
        for(int i = 0; i < length; i ++){
            if(S.charAt(i) == '('){
                result ++;
            }else {
                result --;
                if(result < 0){
                    return 0;
                }
            }
        }
        return result == 0 ? 1:0;
    }


    public static int solution2(String S){
        int length = S.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < length; i ++){
            int a = S.charAt(i);
            if(a == 40){
                stack.push(S.charAt(i));
            }
            if(a == 41 && !stack.empty()){
                stack.pop();
            }
            if(stack.empty()){

            }
        }
        if(stack.empty()){
            return 1;
        }
        return 0;
    }

    //0分
    public static int solution(String S){
        int length = S.length();
        int lon = length / 2;
        int count = 0;
        if(length == 0 || length % 2 != 0){
            return 0;
        }
        for(int i = 0; i < lon; i++){
            int a = S.charAt(i);
            int b = S.charAt(length - i -1);
            if(a + b == 81){
                count ++;
            }
        }
        if(count == lon){
            return 1;
        }
        return 0;
    }
}
