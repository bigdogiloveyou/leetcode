package TOP100;

/**
 * @author xushu
 * @create 5/22/21 7:51 PM
 * @desc
 */
public class Q70_ClimbStairs {

    public int climbStairs(int n) {
        return dfs(n, 0, new int[n]);
    }

    private int dfs(int n, int index, int[] memo){
        if(index == n){
            return 1;
        }

        if(index >= n){
            return 0;
        }

        if(memo[index] != 0){
            return memo[index];
        }

        memo[index] = dfs(n, index + 1, memo) + dfs(n, index + 2, memo);
        return memo[index];
    }
}
