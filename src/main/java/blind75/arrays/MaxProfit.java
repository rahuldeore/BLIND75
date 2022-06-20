package blind75.arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * */
public class MaxProfit {

    public int maxProfit_1(int[] prices) {
        int localMaxProfit=0, buy=0, sell=-1, globalMaxProfit=0;

        for (int i=1; i< prices.length; i++) {
            if (prices[i] < prices[buy]) {
                buy=i;
                sell=-1;
            } else if (sell != -1 && prices[i] > prices[sell]) {
                sell=i;
                localMaxProfit = prices[sell] - prices[buy];
                globalMaxProfit = localMaxProfit > globalMaxProfit ? localMaxProfit : globalMaxProfit;
            } else if (sell==-1) {
                sell=i;
                localMaxProfit = prices[sell] - prices[buy];
                globalMaxProfit = localMaxProfit > globalMaxProfit ? localMaxProfit : globalMaxProfit;
            }
        }
        return globalMaxProfit;
    }

    public int maxProfit(int[] prices) {
        int maxProfit=0, minPrice=Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        MaxProfit maxProfit = new MaxProfit();

        int[] prices_1 = {7,1,5,3,6,4};
        System.out.println("Expected: 5 | Actual: " + maxProfit.maxProfit(prices_1));

        int[] prices_2 = {7,6,4,3,1};
        System.out.println("Expected: 0 | Actual: " + maxProfit.maxProfit(prices_2));

        int[] prices_3 = {2,4,1};
        System.out.println("Expected: 2 | Actual: " + maxProfit.maxProfit(prices_3));

        int[] prices_4 = {3,2,6,5,0,3};
        System.out.println("Expected: 4 | Actual: " + maxProfit.maxProfit(prices_4));

    }
}
