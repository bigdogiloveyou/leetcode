package TOP100;

/**
 * @author xushu
 * @create 5/28/21 10:43 PM
 * @desc
 */
public class Q152_MaxProduct {

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for(int i = 1; i < n; i++){
            if(nums[i] >= 0){
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            }else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
        }

        int res = dp[0][1];
        for(int i = 1; i < n; i++){
            res = Math.max(res, dp[i][1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(new Q152_MaxProduct().maxProduct(nums));
    }
}
