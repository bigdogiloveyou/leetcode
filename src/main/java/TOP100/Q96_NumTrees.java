package TOP100;

/**
 * @author xushu
 * @create 5/25/21 4:29 PM
 * @desc
 */
public class Q96_NumTrees {

    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if(n == 0 || n == 1){
            return 1;
        }

        if(memo[n] != 0){
            return memo[n];
        }

        int count = 0;
        for(int i = 1; i <= n; i++){
            count += dfs(i - 1, memo) * dfs(n - i, memo);
        }

        memo[n] = count;

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q96_NumTrees().numTrees(3));
    }
}
