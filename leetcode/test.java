package com.jhlc.second.second.saunfa;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by licheng on 4/1/16.
 */
public class one {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
    
    public static boolean isValidSudokud(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        // Check for each row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
            set.clear();
        }
        
        // Check for each column
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
            set.clear();
        }
        
        // Check for each sub-grid
        for (int k = 0; k < 9; k++) {
            for (int i = k/3*3; i < k/3*3+3; i++) {
                for (int j = (k%3)*3; j < (k%3)*3+3; j++) {
                    if (board[i][j] == '.')
                        continue;
                    if (set.contains(board[i][j]))
                        return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        
        return true;
    }
    
    /** 检验九宫格 **/
    public static boolean isValidSudoku(char[][] board) {
        Hashtable h;
        //检验每一行
        for (int i = 0; i < board.length; i++) {
            h = new Hashtable();
            for (int j = 0; j < board[i].length; j++) {
                if(h.contains(board[i][j])){
                    return false;
                }
                if(board[i][j] != '.'){
                    h.put(board[i][j], 0);
                }
                
            }
        }
        
        //检验每一列
        for (int i = 0; i < board.length; i++) {
            h = new Hashtable();
            for (int j = 0; j < board[i].length; j++) {
                if(h.contains(board[i][j])){
                    return false;
                }
                if(board[i][j] != '.'){
                    h.put(board[j][i], 0);
                }
            }
        }
        
        //检验每一个框
        for (int i = 0; i < board.length; i ++) {
            int a = 0;
            h = new Hashtable();
            for (int j = i / 3 * 3; j < i / 3 * 3 + 3; j++) {
                for (int k = (i % 3) * 3 ; k < (i % 3) * 3 + 3; k++) {
                    if(h.contains(board[j][k])){
                        return false;
                    }
                    if(board[j][k] != '.'){
                        h.put(board[j][k], 0);
                    }
                }
            }
            
        }
        return true;
    }
    
    /** 将字符串中的元音倒序输出 **/
    public static String reverseVowels(String s) {
        char[] ss = s.toCharArray();
        
        int len = ss.length;
        int[] aa = new int[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if(containVowels(ss[i])){
                aa[j] = i;
                j++;
            }
        }
        char temp;
        for (int z = 0; z < j / 2; z++) {
            temp = ss[aa[j - z - 1]];
            ss[aa[j - z - 1]] = ss[aa[z]];
            ss[aa[z]] = temp;
        }
        return new String(ss);
    }
    
    public static boolean containVowels(char c){
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (int i = 0; i < vowels.length; i++) {
            if(vowels[i] == c){
                return true;
            }
        }
        return false;
    }
    
    /** 将字符串倒序输出 **/
    public static String reverseString(String s) {
        
        char[] ss = s.toCharArray();
        int len = ss.length;
        int i = 0;
        char temp;
        while (i < len/ 2){
            temp = ss[len - i -1];
            ss[len - i - 1] = ss[i];
            ss[i] = temp;
            i ++;
        }
        
        return new String(ss);
    }

    /**
     * 输入PAYPALISHIRING
     * 输出PAHNAPLSIIGYIR
     * 3 1 3 1 ... 循环输出
     * Leetcode上面的ZigZag,理解错了题目的意思
     */
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int index = 0;
        if(numRows == 1){
            return s;
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < len;) {
            
            buffer.append(chars[i]);
            if(index % 2 == 0){
                i += numRows + 1;
                
                if(i > len){
                    index ++;
                    i = index;
                }
                
            }else {
                i += 2;
                
                if(i > len){
                    index ++;
                    i = index;
                }
            }
        }
        return buffer.toString();
    }
    
    /** PAHNAPLSIIGYIR 正解 **/
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len == 0 || numRows <= 1) return s;
        
        String[] ans = new String[numRows];
        Arrays.fill(ans, "");
        int row = 0, delta = 1;
        for (int i = 0; i < len; i++) {
            ans[row] += s.charAt(i);
            row += delta;
            if (row >= numRows) {
                row = numRows-2;
                delta = -1;
            }
            if (row < 0) {
                row = 1;
                delta = 1;
            }
        }
        
        String ret = "";
        for (int i = 0; i < numRows; i++) {
            ret += ans[i];
        }
        return ret;
    }
}
