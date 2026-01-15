package arrays;
//LC 121
public class BuySellStock {
     //BruteForce
//    public int maxProfit(int[] prices) {
//
//        int len = prices.length;
//        int max_profit = 0;
//
//        for(int i =0; i<len-1; i++)
//        {
//            int buy = i;
//            int sell = i+1;
//
//            while(sell<=len-1)
//            {
//
//                int profit = prices[sell]-prices[buy];
//
//                if(profit>0)
//                {
//                    max_profit = Math.max(profit, max_profit);
//                    sell++;
//                }
//                else
//                {
//                    sell++;
//                }
//            }
//
//        }
//        return max_profit;
//    }
//}

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
