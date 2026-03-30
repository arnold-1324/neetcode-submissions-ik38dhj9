class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int maxProfit=0;
        for(int n:prices)
        {
            if(n<min)min=n;
            int CurrProfit=n-min;
            if(maxProfit<CurrProfit) maxProfit=CurrProfit;
        }
        return maxProfit;
    }
}
