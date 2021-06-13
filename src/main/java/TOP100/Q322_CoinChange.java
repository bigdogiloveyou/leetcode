package TOP100;

import java.util.Arrays;

/**
 * @author xushu
 * @create 6/6/21 1:48 PM
 * @desc
 */
public class Q322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for (int coin : coins) {
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Q322_CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }
}
