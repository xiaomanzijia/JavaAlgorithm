package com.jhlc.second.second.saunfa;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by licheng on 26/12/15.
 */
public class Brackets {
    public static void main(String[] args) {
        String S = "{}}}{{{";
        System.out.println(solution(S));
    }

    //87分 https://codility.com/demo/results/training5G8SAN-Y5Q/
    public static int solution(String S){
        int length = S.length();
        Stack<Character> stack = new Stack<>();
        CharacterThree characterThree = new CharacterThree();
        characterThree.fillCharaters();
        for(int i = 0; i < length; i ++){
            char c = S.charAt(i);
            if(characterThree.hasCharacter(c)){
                stack.push(c);
            }else if(!stack.empty()){
                if(characterThree.getCharacter(c) == stack.peek()){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        return stack.size() == 0 ? 1 :0;
    }

    /**
     *
     * @param stack
     * @param type push or pops
     */
    public static void printStack(Stack<Character> stack,String type){
        for(int j = 0; j < stack.size(); j ++){
            System.out.print(stack.get(j)+" ");
        }
        System.out.println(type);
    }

    public static class CharacterThree {
        Map<Character,Character> map = new HashMap<>();
        public void fillCharaters(){
            map.put(']','[');
            map.put(')','(');
            map.put('}','{');
        }
        public boolean hasCharacter(char c){
            return map.containsValue(c);
        }
        public Character getCharacter(char c){
            return map.get(c);
        }
    }
}
