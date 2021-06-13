package TOP100;

/**
 * @author xushu
 * @create 6/5/21 1:44 PM
 * @desc
 */
public class Q221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return 0;
        }

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        // 相当于已经预处理新增第一行、第一列为0
        int[][] dp = new int[height + 1][width + 1];

        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                if(matrix[row][col] == '1'){
                    dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                    maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
