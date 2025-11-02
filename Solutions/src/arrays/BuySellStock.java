package arrays;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int buy_price = prices[0];
        int profit = 0;
        int current_profit = 0;

        for(int i =1;i<prices.length;i++)
        {
            if(prices[i]<buy_price)
            {
                buy_price = prices[i];
            }
            else
            {
                profit = prices[i] - buy_price;
                current_profit= Math.max(profit,current_profit);
            }
        }

        return current_profit;
    }

}
