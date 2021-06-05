package TOP100;

/**
 * @author xushu
 * @create 5/22/21 12:01 AM
 * @desc
 */
public class Q48_Rotate {

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0){
            return;
        }

        int n = matrix.length;

        boolean[][] used = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(used[i][j]){
                    continue;
                }

                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;

                used[i][j] = true;
                used[j][n - 1 - i] = true;
                used[n - 1 - i][n - 1 - j] = true;
                used[n - 1 - j][i] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        new Q48_Rotate().rotate(matrix);
    }
}
