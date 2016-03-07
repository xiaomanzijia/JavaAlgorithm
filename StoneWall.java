package com.jhlc.second.second.saunfa;

import java.util.Stack;

/**
 * Created by licheng on 26/12/15.
 */
public class StoneWall {
    public static void main(String[] args) {
        int[] str = {8,8,5,7,9,8,7,4,8,3};
        System.out.println(solution(str));
    }
    public static int solution(int[] H){
        int length = H.length;
        if(length < 1) return length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < length; i ++){
            while (!stack.empty() && H[i] < stack.peek()){
                stack.pop();
                res ++;
            }
            if(stack.empty()){
                stack.push(H[i]);
                continue;
            }
            if(H[i] > stack.peek()){
                stack.push(H[i]);
            }
        }
        res += stack.size();
        return res;
    }
}
