package datastruct.ErChaShu.swordoffer;

import java.util.Stack;

/**
 * Created by licheng on 18/5/16.
 */
public class StackQuene {

    private Stack<String> stack1 = new Stack<String>();
    private Stack<String> stack2 = new Stack<String>();

    public void appendTail(String str){
        stack1.push(str);
    }

    public String deleteHead() throws Exception {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new Exception("队列为空,不能删除");
        }
        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        StackQuene stackQuene = new StackQuene();
        stackQuene.appendTail("1");
        stackQuene.appendTail("2");
        stackQuene.appendTail("3");
        stackQuene.appendTail("4");
        System.out.println(stackQuene.deleteHead());
    }
}
