package TOP100;

/**
 * @author xushu
 * @create 5/22/21 7:49 PM
 * @desc
 */
public class Q62_UniquePaths {

    public int uniquePaths(int m, int n) {
        return dfs(m - 1, n - 1, new int[m][n]);
    }

    private int dfs(int m, int n, int[][] memo){
        if(m == 0 || n == 0){
            return 1;
        }

        if(m < 0 || n < 0){
            return 0;
        }

        if(memo[m][n] != 0){
            return memo[m][n];
        }

        memo[m][n] = dfs(m - 1, n, memo) + dfs(m, n - 1, memo);

        return memo[m][n];
    }
}
