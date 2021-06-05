package TOP100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushu
 * @create 5/25/21 4:26 PM
 * @desc
 */
public class Q79_Exist {

    public boolean exist(char[][] board, String word) {
        if(board == null || board[0].length == 0 || word == null || word.length() == 0){
            return false;
        }


        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int start, boolean[][] visited) {
        if(start == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(dfs(board, i + 1, j, word, start + 1, visited) || dfs(board, i - 1, j, word, start + 1, visited)
                || dfs(board, i, j + 1, word, start + 1, visited) || dfs(board, i, j - 1, word ,start + 1, visited)){

            return true;
        }
        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'B','A', 'D'},
                {'D','A', 'D'},
                {'D','C', 'D'}
                };
        String word = "AAB";

        System.out.println(new Q79_Exist().exist(board, word));
    }
}
