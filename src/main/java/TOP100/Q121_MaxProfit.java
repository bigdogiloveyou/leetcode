package TOP100;

/**
 * @author xushu
 * @create 5/28/21 10:38 PM
 * @desc
 */
public class Q121_MaxProfit {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max( - prices[i], dp[i - 1][1]);
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Q121_MaxProfit().maxProfit(prices));
    }
}
