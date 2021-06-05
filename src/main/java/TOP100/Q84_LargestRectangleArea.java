package TOP100;

import java.util.Arrays;

/**
 * @author xushu
 * @create 5/25/21 4:27 PM
 * @desc
 */
public class Q84_LargestRectangleArea {


    public int largestRectangleArea(int[] heights) {

        // 备忘录，找到大于或等于 i 的下标 left
        // for 里面的循环可以优化成 while 跳跃
//        int[] leftMemo = new int[heights.length];
//        for(int i = 0; i < heights.length; i++){
//            int temp = heights[i];
//            int left = i;
//            for(; left >= 0; left--){
//                if(heights[left] < temp){
//                    break;
//                }
//            }
//            leftMemo[i] = left + 1;
//        }

        // 优化
        int[] leftMemo = new int[heights.length];
        leftMemo[0] = -1; // -1 是为了跳出 while 循环
        for(int i = 1; i < heights.length; i++){
            int left = i - 1;
            while(left >= 0 && heights[left] >= heights[i]){
                left = leftMemo[left];
            }
            leftMemo[i] = left;
        }

//        int[] rightMemo = new int[heights.length];
//        for(int i = 0; i < heights.length; i++){
//            int temp = heights[i];
//            int right = i;
//            for(; right < heights.length; right++){
//                if(heights[right] < temp){
//                    break;
//                }
//            }
//            rightMemo[i] = right - 1;
//        }

        // 优化
        int[] rightMemo = new int[heights.length];
        rightMemo[heights.length - 1] = heights.length;
        for(int i = heights.length - 2; i >= 0; i--){
            int right = i + 1;
            while(right < heights.length && heights[right] >= heights[i]){
                right = rightMemo[right];
            }
            rightMemo[i] = right;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (rightMemo[i] - leftMemo[i] - 1));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = {1, 1};
        System.out.println(new Q84_LargestRectangleArea().largestRectangleArea(heights));
    }
}
