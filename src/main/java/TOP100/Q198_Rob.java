package TOP100;

import java.util.Arrays;

/**
 * @author xushu
 * @create 6/5/21 1:40 PM
 * @desc
 */
public class Q198_Rob {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dfs(nums, 0, memo);
    }

    private int dfs(int[] nums, int index, int[] memo){
        if(index >= nums.length){
            return 0;
        }

        if(memo[index] != -1){
            return memo[index];
        }

        int rob = nums[index] + dfs(nums, index + 2, memo);
        int notRob = dfs(nums, index + 1, memo);

        memo[index] =  Math.max(rob, notRob);
        return memo[index];
    }
}
