package TOP100;

/**
 * @author xushu
 * @create 6/6/21 1:46 PM
 * @desc
 */
public class Q309_MaxProfit {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int[][] dp = new int[prices.length][2];

        for(int i = 0; i < prices.length; i++){
            if(i == 0){
               dp[0][0] = 0;
               dp[0][1] = -prices[0];
               continue;
            }else if(i == 1){
                dp[1][0] = Math.max(dp[0][1] + prices[1], 0);
                dp[1][1] = Math.max(-prices[1], dp[0][1]);
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
        }

        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {2, 1};
        System.out.println(new Q309_MaxProfit().maxProfit(prices));
    }
}
