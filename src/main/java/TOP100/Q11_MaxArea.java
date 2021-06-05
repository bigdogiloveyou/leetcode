package TOP100;

/**
 * @author xushu
 * @create 5/19/21 8:58 PM
 * @desc
 */
public class Q11_MaxArea {

    private int max = 0;

    /**
     * 动态规划
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int n = height.length;
        dp(height, 0, n - 1);
        return max;
    }

    private void dp(int[] height, int left, int right){
        if(left >= right){
            return;
        }


        max = Math.max(max, Math.min(height[right], height[left]) * (right - left));
        if(height[left] > height[right]){
            dp(height, left, right - 1);
        }else{
            dp(height, left + 1, right);
        }
    }

    /**
     * 贪心
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1, res = 0;

        while (left < right){
            res = height[left] < height[right] ?
                    Math.max(res, (right - left) * height[left++]) :
                    Math.max(res, (right - left) * height[right--]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Q11_MaxArea().maxArea(height));
    }
}
