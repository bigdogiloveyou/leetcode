package TOP100;

/**
 * @author xushu
 * @create 5/22/21 7:50 PM
 * @desc
 */
public class Q64_MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        return dfs(grid, m - 1, n - 1, new int[m][n]);
    }

    private int dfs(int[][] grid, int m, int n, int[][] memo){
        if(m == 0 && n == 0){
            return grid[m][n];
        }

        if(m < 0 || n < 0){
            return Integer.MAX_VALUE;
        }

        if(memo[m][n] != 0){
            return memo[m][n];
        }

        memo[m][n] = Math.min(dfs(grid, m - 1, n, memo), dfs(grid, m, n - 1, memo)) + grid[m][n];

        return memo[m][n];
    }
}
