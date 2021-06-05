package TOP100;

import java.util.Stack;

/**
 * @author xushu
 * @create 5/20/21 2:12 PM
 * @desc
 */
public class Q20_IsValid {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else if(!stack.isEmpty() && ((c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[') || (c == ')' && stack.peek() == '('))){
                stack.pop();
            }else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "]";
        System.out.println(new Q20_IsValid().isValid(s));
    }
}
