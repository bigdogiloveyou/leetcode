package TOP100;

/**
 * @author xushu
 * @create 6/6/21 1:58 PM
 * @desc
 */
public class Q416_CanPartition {

    public boolean canPartition2(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        Boolean[][] memo = new Boolean[nums.length][sum / 2 + 1];

        return dfs(nums, 0, sum / 2, memo);

    }

    private boolean dfs(int[] nums, int index, int target, Boolean[][] memo) {
        if(index >= nums.length){
            return false;
        }

        if(target == 0){
            return true;
        }

        if(memo[index][target] != null){
            return memo[index][target];
        }

        for (int i = index; i < nums.length; i++) {
            if(nums[i] > target){
                continue;
            }

            boolean res = dfs(nums, i + 1, target - nums[i], memo);
            memo[index][target] = res;
            if(res){
                return res;
            }
        }

        return false;
    }



    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];

        // 背包容量为0，随便怎么拿，都算能把它装满
        for(int i = 0; i <= nums.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= sum / 2; j++){
                if(nums[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][sum / 2];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Q416_CanPartition().canPartition(nums));
    }
}
