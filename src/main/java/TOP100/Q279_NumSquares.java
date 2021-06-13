package TOP100;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xushu
 * @create 6/6/21 1:42 PM
 * @desc
 */
public class Q279_NumSquares {

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int half = (int)Math.sqrt(i);
            if(half * half == i){
                list.add(i);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for (int coin : array) {
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[n] == n + 1 ? 0 : dp[n];
    }

    private int dfs(int[] array, int n, int[] memo) {
        if(n == 0){
            return 0;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(n - array[i] < 0){
                continue;
            }
            min = Math.min(min, dfs(array, n - array[i], memo) + 1);
        }

        memo[n] = min == Integer.MAX_VALUE ? 0 : min;
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Q279_NumSquares().numSquares(12));
        System.out.println(Math.sqrt(5));
    }
}
