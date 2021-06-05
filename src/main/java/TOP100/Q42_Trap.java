package TOP100;

/**
 * @author xushu
 * @create 5/22/21 12:00 AM
 * @desc
 */
public class Q42_Trap {

    public int trap(int[] height) {
        int sum = 0, leftMax = 0, rightMax = 0;
        int[] leftMemo = new int[height.length];
        int[] rightMemo = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftMemo[i] = leftMax;
        }

        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightMemo[i] = rightMax;
        }

        for(int i = 0; i < height.length; i++){
            sum += Math.max(0, Math.min(leftMemo[i], rightMemo[i]) - height[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Q42_Trap().trap(height));
    }
}
