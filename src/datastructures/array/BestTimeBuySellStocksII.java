package datastructures.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeBuySellStocksII {

    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(input));
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int index = 0;
        while (index < prices.length - 1) {
            int valley;
            int peek;
            while (index < prices.length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            valley = prices[index];
            while (index < prices.length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }
            peek = prices[index];
            maxProfit += peek - valley;
        }
        return maxProfit;
    }
}
