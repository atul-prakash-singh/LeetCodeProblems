package datastructures.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeBuySellStocks {

    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(input));
    }

    private static int maxProfit(int[] prices) {
        int valley = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (valley > prices[i]) {
                valley = prices[i];
            } else {
                int profit = prices[i] - valley;
                if (maxProfit < profit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    private static int maxProfitOptimized(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int valley = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > valley) {
                maxProfit = Math.max(maxProfit, prices[i] - valley);
            } else {
                valley = prices[i];
            }
        }
        return maxProfit;
    }
}
