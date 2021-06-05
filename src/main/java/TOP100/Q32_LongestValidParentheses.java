package TOP100;

import java.util.Stack;

/**
 * @author xushu
 * @create 5/21/21 11:56 PM
 * @desc
 */
public class Q32_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

}
