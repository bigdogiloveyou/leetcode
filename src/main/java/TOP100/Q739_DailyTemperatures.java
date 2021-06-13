package TOP100;

import java.util.Stack;

/**
 * @author xushu
 * @create 6/6/21 2:10 PM
 * @desc
 */
public class Q739_DailyTemperatures {

    public int[] dailyTemperatures2(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                stack.pop();
            }

            int index = stack.isEmpty() ? i : stack.peek();
            res[i] = index - i;
            stack.push(i);
        }

        return res;
    }

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Q739_DailyTemperatures().dailyTemperatures2(new int[]{89,62,70,58,47,47,46,76,100,70});
        for (int re : res) {
            System.out.println(re);
        }
    }
}
