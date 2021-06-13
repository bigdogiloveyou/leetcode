package TOP100;

import java.util.Arrays;

/**
 * @author xushu
 * @create 6/6/21 1:45 PM
 * @desc
 */
public class Q300_LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[][] memo = new int[nums.length + 1][nums.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(nums, -1, 0, memo);
    }

    private int dfs(int[] nums, int left, int right, int[][] memo) {
        if(right >= nums.length){
            return 0;
        }

        if(memo[left + 1][right] != -1){
            return memo[left + 1][right];
        }

        int a = 0, b = 0;
        if(left == -1 || nums[left] < nums[right]){
            a = dfs(nums, right, right + 1, memo) + 1;
        }

        b = dfs(nums, left, right + 1, memo);

        memo[left + 1][right] =  Math.max(a, b);
        return memo[left + 1][right];
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new Q300_LengthOfLIS().lengthOfLIS2(nums));
    }
}
