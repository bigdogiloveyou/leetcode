package TOP100;


import java.util.*;

/**
 * @author xushu
 * @create 6/5/21 1:38 PM
 * @desc
 */
public class Q155_MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public Q155_MinStack() {
        this.minStack = new Stack<>();
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if(minStack.peek().equals(stack.peek())){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Q155_MinStack minStack = new Q155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
