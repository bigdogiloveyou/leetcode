package TOP100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xushu
 * @create 6/6/21 2:00 PM
 * @desc
 */
public class Q494_FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums, target, 0, 0, memo);
    }

    private int dfs(int[] nums, int target, int sum, int i, Map<String, Integer> memo) {
        if(i == nums.length){
            return sum == target ? 1 : 0;
        }

        String key = i + "_" + sum;
        if(memo.containsKey(key)){
            memo.get(key);
        }

        int res = 0;
        res += dfs(nums, target, sum + nums[i], i + 1, memo);
        res += dfs(nums, target, sum - nums[i], i + 1, memo);

        memo.put(key, res);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q494_FindTargetSumWays().findTargetSumWays(new int[]{1}, 1));
    }
}
